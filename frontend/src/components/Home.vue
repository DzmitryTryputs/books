<template>
  <div class="home">
    <a-row>
      <a-col :span="6">
        <a-card title="Transferwise balance">
          <a-tabs defaultActiveKey="1">
            <a-tab-pane>
              <template v-if="true">
                <strong>Accountnumber:</strong>

              </template>
              <p>
                <strong>Available balance:</strong>

              </p>
            </a-tab-pane>
          </a-tabs>
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<script>

export default {
  name: "home",
};
</script>
