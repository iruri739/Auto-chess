<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.name" placeholder="卡牌名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="searchCards">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleAdd">增加卡牌</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table
      :data="users"
      highlight-current-row
      v-loading="listLoading"
      @selection-change="selsChange"
      style="width: 150%;"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column type="index" width="60"></el-table-column>
      <el-table-column prop="name" label="卡牌名称" width="120" sortable></el-table-column>
      <el-table-column prop="type" label="卡牌类别" width="100" sortable></el-table-column>
      <el-table-column prop="hp" label="生命值" width="100" sortable></el-table-column>
      <el-table-column prop="attack" label="攻击力" width="120" sortable></el-table-column>
      <el-table-column prop="price" label="价格" min-width="180" sortable></el-table-column>
      <el-table-column label="操作" width="150">
        <template scope="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button type="danger" size="small" @click="handleDel(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <!-- <el-button type="danger" @click="batchRemove" :disabled="this.sels.length===0">批量删除</el-button> -->
      <el-pagination
        layout="prev, pager, next"
        @current-change="handleCurrentChange"
        :page-size="20"
        :total="total"
        style="float:right;"
      ></el-pagination>
    </el-col>

    <!--编辑界面-->
    <el-dialog title="编辑" :visible.sync="editFormVisible" :close-on-click-modal="false">
      <el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
        <el-form-item label="卡牌名称" prop="name">
          <el-input v-model="editForm.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="卡牌类别">
          <el-radio-group v-model="editForm.type">
            <el-radio class="radio" :label="2">天空类</el-radio>
            <el-radio class="radio" :label="1">海洋类</el-radio>
            <el-radio class="radio" :label="0">陆地类</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="生命值">
          <el-input-number v-model="editForm.hp" :min="0" :max="50"></el-input-number>
        </el-form-item>
        <el-form-item label="攻击力">
          <el-input-number v-model="editForm.attack" :min="0" :max="50"></el-input-number>
        </el-form-item>
        <el-form-item label="价格">
          <el-input-number v-model="editForm.price" :min="0" :max="50"></el-input-number>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="editFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="editSubmit" :loading="editLoading">提交</el-button>
      </div>
    </el-dialog>

    <!--新增界面-->
    <el-dialog title="增加卡牌" :visible.sync="addFormVisible" :close-on-click-modal="false">
      <el-form :model="addForm" label-width="80px" :rules="addFormRules" ref="addForm">
        <el-form-item label="卡牌名称" prop="name">
          <el-input v-model="addForm.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="卡牌类别">
          <el-radio-group v-model="addForm.type">
            <el-radio class="radio" :label="2">天空类</el-radio>
            <el-radio class="radio" :label="1">海洋类</el-radio>
            <el-radio class="radio" :label="0">陆地类</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="生命值">
          <el-input-number v-model="addForm.hp" :min="0" :max="50"></el-input-number>
        </el-form-item>
        <el-form-item label="攻击力">
          <el-input-number v-model="addForm.attack" :min="0" :max="50"></el-input-number>
        </el-form-item>
        <el-form-item label="价格">
          <el-input-number v-model="addForm.price" :min="0" :max="50"></el-input-number>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit" :loading="addLoading">提交</el-button>
      </div>
    </el-dialog>
  </section>
</template>
<script>
export default {
  name: "UserMaster",
  data() {
    return {
      radio: 1,
      filters: {
        name: ""
      },
      users: [],
      total: 0,
      page: 1,
      listLoading: false,
      sels: [], //列表选中列

      editFormVisible: false, //编辑界面是否显示
      editLoading: false,
      editFormRules: {
        name: [{ required: true, message: "请输入卡牌名称", trigger: "blur" }]
      },
      //编辑界面数据
      editForm: {
        name: "",
        type: "",
        price: 1,
        hp: 1,
        attack: 1
      },

      addFormVisible: false, //新增界面是否显示
      addLoading: false,
      addFormRules: {
        name: [{ required: true, message: "请输入卡牌名称", trigger: "blur" }]
      },
      //新增界面数据
      addForm: {
        name: "",
        type: "",
        price: 1,
        hp: 1,
        attack: 1
      }
    };
  },
  //页面响应
  mounted() {
    this.getUsers();
  },
  computed: {},

  methods: {
    //获取用户列表
    getUsers() {
      debugger;
      let para = {
        page: this.page,
        name: this.name
      };
      this.listLoading = true;
      this.$http.get("http://localhost:8888/Admin/getAll").then(resp => {
        this.total = resp.data.total;
        this.users = resp.data;
        this.listLoading = false;
      });
    },
    selsChange: function(sels) {
      this.sels = sels;
    },

    //显示新增界面
    handleAdd: function() {
      this.addFormVisible = true;
      this.addForm = {
        name: "",
        type: "",
        price: 1,
        hp: 1,
        attack: 1
      };
    },

    //编辑
    editSubmit: function() {
		this.editFormVisible = false;
      this.$http
        .post("http://localhost:8888/Admin/updateCard/", {
          name: this.editForm.name,
          type: this.editForm.type,
          hp: this.editForm.hp,
          price: this.editForm.price,
          attack: this.editForm.attack
        })
        .then(() => {
          this.$message({
            message: "编辑成功",
            type: "success"
          });
          this.getUsers();
        });
    },

    //查询
    // handleCurrentChange(val) {
    // this.page = val;
    // this.searchCards();
    // 	},

    searchCards() {
      debugger;
      let para = {
        page: this.page,
        name: this.filters.name
      };
      this.listLoading = true;
      this.$http
        .get(`http://localhost:8888/Admin//searchCard?chess_name=${para.name}`)
        .then(resp => {
          this.total = resp.data.total;
          this.users = resp.data;
          this.listLoading = false;
        });
    },

    //显示编辑界面
    handleEdit: function(index, row) {
      this.axios.post();
      this.editFormVisible = true;
      this.editForm = Object.assign({}, row);
    },
    //新增
    addSubmit: function() {
		this.addFormVisible=false;
      this.$http
        .post("http://localhost:8888/Admin/insertChess/", {
          name: this.addForm.name,
          type: this.addForm.type,
          hp: this.addForm.hp,
          price: this.addForm.price,
          attack: this.addForm.attack
        })
        .then(() => {
          this.$message({
            message: "提交成功",
            type: "success"
          });
          this.getUsers();
        });
    },
    //删除
    handleDel: function(index, row) {
      this.$confirm("确认删除该卡牌吗?", "提示", {
        type: "warning"
      })
        .then(() => {
          this.listLoading = true;

          this.$http
            .get(`http://localhost:8888/Admin//deleteCard?chess_id=${row.id}`)
            .then(resp => {
              this.listLoading = false;
              this.total = resp.data.total;
              this.users = resp.data;
              this.$message({
                message: "删除成功",
                type: "success"
              });
              this.getUsers();
            });
        })
        .catch(() => {});
    }
  }
};
</script>
<style scoped>
</style>