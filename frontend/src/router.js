import Vue from 'vue';
import Router from 'vue-router';
import BooksList from "./components/books/Books";
import Home from "./components/Home";

Vue.use(Router);

let router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/books',
      name: 'books',
      component: BooksList
    }
  ]
});

export default router;
