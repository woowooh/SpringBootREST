<template>
    <div class="row">
    <div class="col-sm-8 col-sm-offset-2 blog-main">
        <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">Panel heading</div>
        <div class="panel-body">
            <p>Some default panel content here. Nulla vitae elit libero, a pharetra augue. Aenean lacinia bibendum nulla sed consectetur. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
        </div>
        <!-- Table -->
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Account</th>
                <th>Add Time</th>
                <th>Last modify</th>
                <th>Expire At</th>
                <th>Operation</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(user, index) in users" :key=index >
                <td scope="row" class="middle">{{ index + 1}}</td>
                <td class="middle">{{ user.account }}</td>
                <td class="middle">{{ user.createTime }}</td>
                <td class="middle">{{ user.updateTime }}</td>
                <td class="middle">{{ user.expireTime}}</td>
                <td>
                    <el-button type="text" size="medium" class="btn btn-default enable" >启用</el-button>
                    <el-button type="text" size="medium" class="btn btn-default forbidden" >禁用</el-button>
                    <el-button type="text" size="medium" class="btn btn-default normal" @click="dialogFormVisible=true">过期</el-button>
                </td>
            </tr>
            </tbody>
        </table>
        </div>
        <el-dialog title="过期时间" :visible.sync="dialogFormVisible" width="30%">
             <div class="block">
                <span class="demonstration">选择过期时间</span>
                <el-date-picker
                v-model="expireTime"
                type="datetime"
                placeholder="选择日期时间"
                align="right"
                :picker-options="pickerOptions">
                </el-date-picker>
            </div>
        </el-dialog>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: "manage-page",
    data() {
        return {
            users: [],
            dialogFormVisible: false,
            formLabelWidth: '60px',
            pickerOptions: {
            disabledDate(time) {
          },
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
        expireTime: '',
      }
    },
    methods: {
        diasble: function() {
            $('#sandbox-container div').datepicker({
                daysOfWeekDisabled: "2"
            });
            // var path = "http://localhost:8082/user/disable"
            // axios.post(path, {}).then(res => {          
                
            // }) 
        }
    },
    created() {    
        var path = "http://localhost:8082/user/userList"
        axios.get(path).then(res => {
            this.users = res.data.data;        
        })
    },
}
</script>
<style scoped>
.blog-main {
    text-align: left;
}
.enable {
    color: green;
}
.enable:hover{
    color: #67C23A;
    border-color: transparent;
}
.forbidden {
    color: red;
}
.forbidden:hover{
    color: #F56C6C;
    border-color: transparent;
}
.normal {
    color: #2c3e50;
}
.normal:hover{
    color: #909399;
    border-color: transparent;
}
.middle {
   vertical-align: middle;
}
</style>