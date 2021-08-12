/*$("#queryCategoryLevel1").change(function(){
    var queryCategoryLevel1=$("#queryCategoryLevel1").val();
    if(queryCategoryLevel1 != '' && queryCategoryLevel1 != null){
    	//发送ajax
		$.getJSON("/app/manager/backend/app/categorylevelist",{parentId:queryCategoryLevel1},function(data){
            var options = "<option value=\"\">--请选择--</option>";
            for(var i = 0; i < data.length; i++){
                options += "<option value=\""+data[i].id+"\">"+data[i].categoryname+"</option>";
            }
            $("#queryCategoryLevel2").html(options);

		});

	}else{
    	//清空二级列表
        $("#queryCategoryLevel2").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#queryCategoryLevel2").html(options);
    }
    //清空三级列表
    $("#queryCategoryLevel3").html("");
    var options = "<option value=\"\">--请选择--</option>";
    $("#queryCategoryLevel3").html(options);
})*/

$("#queryCategoryLevel1").change(function (){
    var queryCategoryLevel1=$("#queryCategoryLevel1").val();
    if (queryCategoryLevel1!='' &&queryCategoryLevel1!=null){
        $.getJSON("/app/manager/backend/app/categorylevellist",{parentId:queryCategoryLevel1},function (result){
            $("#queryCategoryLevel2").html("");

            var str="<option value=\"\">--请选择--</option>"
            for (var i=0;i<result.length;i++){
                str+= "<option value=\""+result[i].id+"\">"+result[i].categoryName+"</option>";
            }
            /*alert(str)*/
            $("#queryCategoryLevel2").html(str);
        });
    }else {
        $("#queryCategoryLevel2").html("");
        var str = "<option value=\"\">--请选择--</option>";
        $("#queryCategoryLevel2").html(str);
    }
    $("#queryCategoryLevel3").html("");
    var str = "<option value=\"\">--请选择--</option>";
    $("#queryCategoryLevel3").html(str);
})
$("#queryCategoryLevel2").change(function (){
    var queryCategoryLevel2=$("#queryCategoryLevel2").val();
    if (queryCategoryLevel2!='' &&queryCategoryLevel2!=null){
        $.getJSON("/app/manager/backend/app/categorylevellist",{parentId:queryCategoryLevel2},function (result){
            var str="<option value=\"\">--请选择--</option>"
            for (var i=0;i<result.length;i++){
                str+= "<option value=\""+result[i].id+"\">"+result[i].categoryName+"</option>";
            }
            $("#queryCategoryLevel3").html(str);
        });
    }else {
        $("#queryCategoryLevel3").html("");
        var str = "<option value=\"\">--请选择--</option>";
        $("#queryCategoryLevel3").html(str);
    }
})


$(".checkApp").on("click",function(){
	var obj = $(this);
	var status = obj.attr("status");
	var vid = obj.attr("versionid");
	if(status == "1" && vid != "" && vid != null){//待审核状态下才可以进行审核操作
        //将后端一个方法的多个参数带到后端另一个方法
		window.location.href="check?aid="+ obj.attr("appinfoid") + "&vid="+ obj.attr("versionid");
	}else if(vid != "" || vid != null){
		alert("该APP应用没有上传最新版本,不能进行审核操作！");
	}else if(status != "1"){
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能进行审核操作！");
	}
});
/*$(".checkApp").click(function(){
	var obj=$(this);
	var status =obj.attr("status");
	var vid =obj.attr("versions");
	if(status =="1" && vid!="" && vid !=null){
		location.href="check?aid="+obj.attr("appinfoid")+ "&vid="+ obj.attr("versionid");
	}else if(vid!=""|| vid!=null){
		alert ("该APP应用没有上传的版本")
	}else if(status != "1"){
        alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能进行审核操作！");
    }
})*/


	
