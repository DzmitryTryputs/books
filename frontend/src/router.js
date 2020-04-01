import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      component: () => import('@/views/components/core/Index'),
      children: [
        {
          name: 'Books',
          path: '/books',
          component: () => import('@/views/books/Books'),
        },
        {
          path: '/books/create',
          name: 'Create Book',
          component: () => import('@/views/books/Create'),
        },
        {
          name: 'Authors',
          path: '/authors',
          component: () => import('@/views/authors/Authors'),
        },
        {
          name: 'Create Author',
          path: '/authors/create',
          component: () => import('@/views/authors/Create'),
        },
      ],
    },
  ],
})
