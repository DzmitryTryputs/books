import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/base'
import './plugins/chartist'
import './plugins/vee-validate'
import vuetify from './plugins/vuetify'
import i18n from './i18n'
import axios from 'axios';

Vue.config.productionTip = false
Vue.prototype.$http = axios;

new Vue({
  router,
  store,
  vuetify,
  i18n,
  render: h => h(App),
}).$mount('#app')

const token = localStorage.getItem('token');
if (token) {
  Vue.prototype.$http.defaults.headers.common['Authorization'] = token;
}


// Creates a new promise that automatically resolves after some timeout:
Promise.delay = function(time) {
  return new Promise((resolve, reject) => {
    setTimeout(resolve, time);
  });
};

// Throttle this promise to resolve no faster than the specified time:
Promise.prototype.takeAtLeast = function(time) {
  return new Promise((resolve, reject) => {
    Promise.all([this, Promise.delay(time)]).then(([result]) => {
      resolve(result);
    }, reject);
  });
};

