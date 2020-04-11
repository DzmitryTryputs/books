import Vue from 'vue'
import Router from 'vue-router'
import store from './store.js'

import Login from './views/auth/Login'
import Books from './views/books/Books'

Vue.use(Router)

let router = new Router({
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
          component: Books,
          meta: {
            requiresAuth:true
          }
        },
        {
          path: '/books/create',
          name: 'Create Book',
          component: () => import('@/views/books/Create'),
          meta: {
            requiresAuth:true
          }
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
        {
          name: 'Login',
          path: '/login',
          component: Login,

        },
        {
          name: 'Register',
          path: '/register',
          component: () => import('@/views/auth/Register'),
        }
      ],
    },
  ],
})

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    if (store.getters.isLoggedIn) {
      next();
      return;
    }
    next('/login');
  } else {
    next();
  }
});

export default router;
