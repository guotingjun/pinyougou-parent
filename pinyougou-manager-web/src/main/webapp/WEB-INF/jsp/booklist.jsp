<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap3/js/bootstrap.js"></script>
<link rel="stylesheet" href="../js/bootstrap3/css/bootstrap.css" />

<script src="../js/bootstrap-table/bootstrap-table.js"></script>
<script src="../js/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<link rel="stylesheet" href="../js/bootstrap-table/bootstrap-table.css" />

<script src="../js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="../js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css" />

<script src="../js/bootstrap-bootbox/bootbox.all.min.js"></script>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">高级搜索</div>
		<div class="panel-body">
			<form class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-1 control-label">名称</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="searchName" />
					</div>
					<div class="col-sm-5 col-sm-offset-1">
						<button onclick="searchBook()" type="button" class="btn btn-info btn-lg btn-block"><i class="glyphicon glyphicon-search"></i>搜索</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="toolbar">
		<button onclick="openAddDialog()" type="button" class="btn btn-info"><i class="glyphicon glyphicon-plus"></i>新增</button>
		<button onclick="deleteBook()" type="button" class="btn btn-info"><i class="glyphicon glyphicon-minus"></i>批量删除</button>
	</div>
	<div id="bookTable"></div>
</body>
<script type="text/javascript">
function deleteBook() {
    var arr = $("#bookTable").bootstrapTable("getSelections");
    var ids="";
    for (var i = 0; i < arr.length; i++) {
        ids+=ids==''?arr[i].id:','+arr[i].id;
	}	
    bootbox.confirm({
        title: "删除信息?",
        message: "你确定要删除选中的信息吗.",
        buttons: {
        cancel: {
            label: '<i class="fa fa-times"></i> 取消'
        },
        confirm: {
            label: '<i class="fa fa-check"></i> 确认'
        }
    },
        callback: function(result) {
        	$.post('../brand/delTypeIds.do',{ids:ids},function(data){
        		   if (data) {
        			   searchBook();
        			}else{
        				bootbok.alert({
        					title:'提示',
        					message:'删除失败',
        					size:'small'
        				})
        			}
        	   })
        }
    })
}

       

	var res;
	function createAddContent(url){
		$.ajax({
			url:url,
			async:false,
			success:function(data){
				res = data;
			}
		});
		return res;
	}

	function openAddDialog(){
		bootbox.dialog({
			title:'<i class="glyphicon glyphicon-book"></i>新增图书',
			message:createAddContent('../page/toAddPage.do'),
			size:'large',
			buttons:{
				cancel:{
					label:"取消",
					className:'btn-danger',
					callback:function(){						
					}
				},
				ok:{
					label:"保存",
					className:'btn-info',
					callback:function(){	
						saveBook();
					}
				}
			}
		})
	}
	
	function openEditDialog(id){
		bootbox.dialog({
			title:'<i class="glyphicon glyphicon-book"></i>编辑图书',
			message:createAddContent('../page/toEditPage.do'),
			size:'large',
			buttons:{
				cancel:{
					label:"取消",
					className:'btn-danger',
					callback:function(){						
					}
				},
				ok:{
					label:"保存",
					className:'btn-info',
					callback:function(){	
						saveBook();
					}
				}
			}
		})
		initBookTableSelected();
		$.post('../user/findBookInfoById.do',{id:id},function(data){
			$("#id").val(data.id);
			$("input[name='name']").val(data.name);
			$("input[name='price']").val(data.price);
			$("input[name='author']").val(data.author);
			$("#bookTypeSelect").val(data.typeId);
			$("input[name='createTime']").val(data.createTime);
			$("#hideImg").val(data.img == null ? "" : data.img);
			initFileInput(data.img == null ? "" : data.img);
		})
	}
	
	function saveBook(){
		$.ajax({
			url:'../user/saveBook.do',
			type:'post',
			data:$("#bookForm").serialize(),
			dataType:'json',
			success:function(data){
				if (data) {
					searchBook();
				}else{
					bootbok.alert({
						title:'提示',
						message:'保存失败',
						size:'small'
					})
				}
			}
		})
	}
	
	function searchBook(){
		
		$('#bookTable').bootstrapTable('refresh',{
			query:{
				page:1
				
			}
		})
	}

	$(function(){
		initBookTable();
		/*initSearchType();*/
	})

	function initSearchType(){
		$.post('../user/findBookTypeList.do',{},function(data){
			var html = '<option value="-1">请选择</option>';
			for (var i = 0; i < data.length; i++) {
				html += '<option value="'+data[i].id+'">'+data[i].name+'</option>';
			}
			$("#searchType").html(html)
		})
	}
	
	function initBookTable(){
		$('#bookTable').bootstrapTable({
			url:'../user/findType.do',
			method:'post',
			contentType:'application/x-www-form-urlencoded',//post请求按照表单方式
			pagination:true,
			pageSize:2,
			pageList:[2,4,6,8,10],
			pageNumber:1,
			clickToSelect: true,
			sidePagination:'server',//分页方式：client客户端分页，server服务端分页（
			striped:true,
			queryParams:function(){
				var searchName = $("#searchName").val();
				/*var searchType = $("#searchType").val();
				var startTime = $("#startTime").val();
				var endTime = $("#endTime").val();*/
				return {
					page:this.pageNumber,
					rows:this.pageSize,
					name:searchName,
					/*typeId:searchType,
					startTime:startTime,
					endTime:endTime*/
				}
			},
			columns:[
				{checkbox:true},
				{field:'id',title:'分类ID'},
				{field:'name',title:'分类名称'},
				{field:'1',title:'分组',
					formatter:function(value,row,index){
						return '首页广告';
					}
				},
				{field:'2',title:'KEY',
					formatter:function(value,row,index){
						return 'index';
					}
				},
				{field:'3',title:'状态',
					formatter:function(value,row,index){
						return '有效';
					}
				},
				{field:'cz',title:'操作',
					formatter:function(value,row,index){
						return '<a href="javascript:openEditDialog('+row.id+');">修改</a>';
					}
				}
			]
		})
	}
	
	$('.date').datetimepicker({
		  language: 'zh-CN',//显示中文
		  format: 'yyyy-mm-dd hh:ii:ss',//显示格式
		  minView: "month",//设置只显示到月份
		  initialDate: new Date(),//初始化当前日期
		  autoclose: true,//选中自动关闭
		  todayBtn: true//显示今日按钮
		 });
</script>
</html>