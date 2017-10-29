$(function() {
    allCheck();

    $('.main').niceScroll({
        cursorcolor: '#ccc'
    });
//
    var tableTitle = [{
        field: "select",
        title: "",
    }, {
        field: "contact",
        title: "联系人",
    }, {
        field: "contactWay",
        title: "移动/固定电话",
    }, {
        field: "companyName",
        title: "公司名称",
    }, {
        field: "customerClaim",
        title: "客户认领",
    }, {
        field: "mail",
        title: "QQ/邮箱",
    }, {
        field: "province",
        title: "所在省份",
    }, {
        field: "createTime",
        title: "创建时间",
    }, {
        field: "operate",
        title: "",
        formatter:function(value,row,index){
            console.log(row.id);
            var dopt = '<p class="modify"> · · · </p>';
            var e = '<a href="editCustomer.html" mce_href="#">编辑</a> ';  
            var d = '<a href="#" mce_href="#" class="delete">删除</a> ';
            var u = '<ul><li>'+e+'</li><li>'+d+'</li></ul>'
            return dopt+u;  
        } 
    }];
//
    var tableData = [{
        "id": 0,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    },{
        "id": 1,
        "select": "<label class='forCheckbox'><input type='checkbox'></label>",
        "contact": "<p>汤姆斯1</p>",
        "contactWay": "<p>123123</p><p>123456798</p>",
        "companyName": "<p class=''>广州润普网络科技有限公司<p>",
        "customerClaim": "<p class=''>张三</p>",
        "mail": "<p class=''>1231321321</p><p class=''>1321313213</p>",
        "province": "<p class=''>广东省</p>",
        "createTime": "<p class='createTime'>2017/9/18 10:00<p>",
        "operate": "<p class='modify'> · · · </p>",
    }];
//
    $('#table').bootstrapTable('destroy').bootstrapTable({
        columns: tableTitle,
        data: tableData,
        pagination: true,
        paginationPreText: '上一页',
        paginationNextText: '下一页',
        formatLoadingMessage: function(){
            return null;
        }
        // url: 'js/data.json'
    });
    $('.customerNum span').text($('#table tbody tr').length);
    checkboxClick();

    // $('.pull-right.pagination').append('<ul>1234</ul>')
    $('.filter').click(function(){
        $('.filterPop').addClass('dblock').removeClass('dnone');
    });

    $('.filterPop .sure').click(function() {
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });
    $('.filterPop .cancel').click(function() {
        $('.filterPop').addClass('dnone').removeClass('dblock');
    });

    $('.addCondition').click(function() {
        $(this).before('<div class="itemgroup">' +
            '<select class="col_1">' +
                '<option>客户名称</option>' +
                '<option>标签</option>' +
                '<option>地区</option>' +
                '<option>联系人</option>' +
                '<option>联系方式</option>' +
            '</select>' +
            '<select class="col_2">' +
                '<option>包含</option>' +
                '<option>不包含</option>' +
            '</select>' +
            '<input type="text" class="col_3">' +
        '</div>')
    });

    $('.allOperate .delete').click(function() {
        $('tbody tr').each(function(index, el) {
            if ($(this).find('.forCheckbox input').prop('checked') == true) {
                $(this).remove();
                //ajax
            }
        });
    });

    $('tbody tr .delete').click(function() {
        $(this).parents('tr').remove();
    });

    $('tbody').on('click', 'tr input[type=checkbox]', function(event) {
        event.stoppropagation();
        event.preventDefault();
        allOperateShowHide();
    })

    // $('body').on('click', 'tbody tr', function() {
    //     location.href="editCustomer.html";
    // })


});












function allOperateShowHide() {
    for (var i = 0; i < $('tbody tr').length; i++) {
        if ($('tbody tr').eq(i).find('input[type=checkbox]').prop('checked') === true) {
            $('.allOperate').addClass('dblock').removeClass('dnone');
            break;
        } else {
            $('.allOperate').removeClass('dblock').addClass('dnone');
        }
    }
}







function checkboxClick() {
    $('body').on('click', 'tbody input[type=checkbox]', function() {
        var x = 0;
        var mx = $('tbody tr').length;
        for (var i = 0; i < mx; i++) {
            if ($('tbody tr').eq(i).find('input[type=checkbox]').prop('checked') === true) {
                x++
            }
        }
        if (x != (mx - 1)) {
            $('.allOperate input').prop('checked', false);
        } else {
            $('.allOperate input').prop('checked', true);
        }
    })
}

function allCheck() {
    $('.allOperate input').click(function() {
        if($(this).prop('checked') == true) {
            for(var i = 0; i < $('tbody').find('tr').length; i++) {
                $('tbody').find('input[type=checkbox]').eq(i).prop('checked', true);
            }
        } else {
            for(var i = 0; i < $('tbody').find('tr').length; i++) {
                $('tbody').find('input[type=checkbox]').eq(i).prop('checked', false);
            }
        }
        allOperateShowHide();
    });
}



// function del(id){
//     $(this).parents('tr').remove();
// }