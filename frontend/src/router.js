import Vue from 'vue';
import Router from 'vue-router';
import BooksList from "./components/books/Books";
import Home from "./components/Home";
import CreateBook from "./components/books/Create";
import AuthorsList from "./components/authors/Authors";
import CreateAuthor from "./components/authors/Create";

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
    },
    {
      path: '/books/create',
      name: 'createBook',
      component: CreateBook
    },
    {
      path: '/authors',
      name: 'authors',
      component: AuthorsList
    },
    {
      path: '/authors/create',
      name: 'createAuthor',
      component: CreateAuthor
    }
  ]
});

export default router;
