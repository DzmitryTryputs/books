<template>
<div/>
</template>
<script>

export default {
  name: "CreateBook",
  data() {
    return {

    };
  },
  computed: {},
  methods: {},
  mounted: function() {
  }
};
</script>

<style lang="scss" scoped>
#editable-add-btn {
  margin: 20px;
}
.taxRateContainer {
  background-color: #f9edbe;
  border: 1px solid #f0c36d;
  padding: 30px;
  margin-right: 30px;
}
.contentHeader {
  font-weight: bold;
  font-size: 1.1rem;
  margin-bottom: 10px;
  border-bottom: 3px solid #bbb;
  padding-top: 20px;
  padding-bottom: 5px;
  display: flex;
  justify-content: space-between;
}
.serviceDate {
  font-size: 1rem;
  font-weight: normal;
  display: flex;
  align-items: baseline;
}
.serviceDate a {
  text-decoration: underline;
  margin-left: 5px;
}
.invoiceTotal {
  padding: 30px 0;
  border-top: 3px solid #bbbbbb;
}
.invoiceTotal span,
.sumValue {
  font-weight: bold;
}
.sum {
  padding-top: 5px;
  border-top: 1px solid #000;
  display: flex;
  justify-content: space-between;
}
.paper {
  background: #fff;
  box-shadow:
    /* The top layer shadow */ 0 -1px 1px rgba(0, 0, 0, 0.15),
    /* The second layer */ 0 -10px 0 -5px #eee,
    /* The second layer shadow */ 0 -10px 1px -4px rgba(0, 0, 0, 0.15),
    /* The third layer */ 0 -20px 0 -10px #eee,
    /* The third layer shadow */ 0 -20px 1px -9px rgba(0, 0, 0, 0.15);
  padding: 30px;
}

.priceHeader {
  font-weight: bold;
}
.companyInformation {
  margin-bottom: 10px;
}
.metaList {
  padding: 0;
  margin: 0;
  width: 100%;
  float: right;
}
.metaList li {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  list-style: none;
  padding: 0;
  margin-bottom: 10px;
}
.metaList li span {
  flex: 1;
}
.metaList li > div {
  width: 30%;
  margin-right: 5%;
  font-weight: bold;
}
#saveForm {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  box-shadow: 0 -1px 4px rgba(0, 0, 0, 0.08);
  background: #fff;
  border-top: 1px solid #e2e3e4;
  padding: 10px 0 10px 0;
  height: auto;
  display: flex;
  align-items: center;
  &:before {
    content: "";
    position: absolute;
    left: 0;
    top: 0;
    background: linear-gradient(
      180deg,
      rgba(0, 0, 16, 0.05) 0,
      hsla(0, 0%, 100%, 0)
    );
    transform: translateY(0);
    height: 15px;
    width: 100%;
    transition: opacity 0.2s ease-in-out;
  }
  .ant-form-item {
    margin-bottom: 0;
  }
  #saveFormInner {
    width: 100%;
    max-width: 980px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
}
</style>
