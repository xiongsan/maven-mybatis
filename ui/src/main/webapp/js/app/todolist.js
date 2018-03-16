define(["base","datatables.net","enclosure"],function(base,DataTable){
    var grid1date = null;
function setTable(){
            var grid1Option ={
                "searching":false,
                "lengthChange":true,
                "autoWidth":false,
                "serverSide":true,
                "paging":true,
                "stateSave":true,
                "ordering":false,
                "lengthMenu":[22],
                "language":{"url":$.base+"/js/lib/chinese.json"},
                "ajax":{
                    "type":"post",
                    "url":sweets.getPageUrl("todoListServiceImpl",'getPageData'),
                    "data": function ( d ) {
                        d.start =d.start==0?d.start:d.start+2;
                        d.length = 22;
                        var params={
                            pageNo: d.start/d.length+1,
                                pageSize: d.length,
                                param:{

                                }
                        };
                        return {param:JSON.stringify(params)};
                    }
                },
                "columns":[
                    {"title":"序号","data":"id","sWidth":"4%"},
                    {"title":"名字", "data":"title","sWidth":"24%"},
                    {"title":"检查", "data":"checked","sWidth":"24%"},
                    {"title":"性别", "data":"sex","sWidth":"24%"},
                    {"title":"操作", "data":"operate","sWidth":"24%"}
                ],
                "columnDefs":[
                    {
                        "render":function(data,type,row,meta){
                            return meta.row+1+meta.settings._iDisplayStart;
                        },
                        "targets":0
                    },
                    {
                        "render":function(data,type,row,meta){
                            var html="";
                            html="<span class='widthLength widthLengthEx' style='width:100%;text-align: center' title='"+data+"'>"+data+"</span>";
                            return html;
                        },
                        "targets":1
                    },
                    {
                        "render":function(data,type,row,meta){
                            var html="";
                            html="<span class='widthLength' title='"+data+"' style='width:100%;text-align: center'>"+data+"</span>";
                            return html;
                        },
                        "targets":2
                    },
                    {
                        "render":function(data,type,row,meta){
                            var html="";
                            html="<span class='widthLength' title='"+data+"' style='width:100%;text-align: center'>"+data+"</span>";
                            return html;
                        },
                        "targets":3
                    },
                    {"render":function(data,type,row,meta){

                        return  "<div class='clearfix'>" +
                            "<div style='display:inline-block;'><button class='btn btn-link delete' rowId='"+row.id+"'>删除</button></div>&nbsp;&nbsp;&nbsp;&nbsp;";

                    },
                        "targets":4
                    }
                ],

                "drawCallback":function(setting){
                    $("#tblLiveApproval_length").hide();
                    $(".delete").off().on("click",function(){
                        var id=$(this).attr("rowId")
                        sweets.startService("todoListServiceImpl","deleteTodo",{param:{id}}).then(function (e) {
                            if(e.status==='1'){
                                grid1date.ajax.reload()
                            }
                            else{
                                alert('删除失败')
                            }
                        })
                    });
                }
            }
                 grid1date= $("#tblLiveApproval").DataTable(grid1Option);
	    };

	    function setPage(){
			//时间插件
			 base.form.date({
				 element:$(".date"),
				 isTime:true,
				 theme:"#00479d",
				 dateOption:{ 
					// min:getNowFormatDate(),
					 max: "2099-06-16 23:59", //最大日期
					 format: 'yyyy-MM-dd HH:mm'
				 }
			 });

        };

		return {
			run:function(){
				setTable();
				setPage();
			}
		};
});
