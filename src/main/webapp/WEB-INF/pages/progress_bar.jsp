<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>

<meta charset="UTF-8">
<style type="text/css">
#wrapper{
    position: relative;
    width:200px;
    height:80px;
    border:1px solid darkgray;
}
#progressbar{
    position: relative;
    /*top:50%;*/
    /*left:50%;*/
    margin-left:10px;
    margin-top:10px;
    width:150px;
    height:30px;
    border:1px solid darkgray;

}
/*在进度条元素上调用动画*/
#fill{
    animation: move 600s;
    text-align: center;
    font-size:15px;
    height:30px;
    background-color: red;
}
/*实现元素宽度的过渡动画效果*/
@keyframes move {
    0%{
        width:0;
        background-color: yellow;

    }
    /*50%{*/
        /*width:50%;*/
        /*background-color: orange;*/

    /*}*/
    100%{
        width:100%;
        background-color: red;
    }
}

</style>

</head>

<body>
<div id="wrapper">
    <!--进度条容器-->
    <div id="progressbar">
        <!--用来模仿进度条推进效果的进度条元素-->
        <div id="fill"></div>
    </div>
    <p id="remainingTime">limit time: ${limitTime} minutes</p>
</div>


<script>
    var progressbar={
                init:function(flag){
                    if (flag){
                        //将截取的字符串进行打印
                        var fill=document.getElementById("fill");
                        fill.style.cssText = "animation: move 0.1s;"
                        var count=0;
                    //通过间隔定时器实现百分比文字效果,通过计算CSS动画持续时间进行间隔设置
                        var timer=setInterval(function(e){
                            fill.innerHTML=100+'%';
                        },4);
                    } else {
                        var fill=document.getElementById("fill");
                        // var time = document.getElementById("remainingTime").innerText;
                        // fill.style.cssText = "animation: move 600s;"
                        var value = "${requestScope.limitTime}";
                        var time = "animation: move "+value*60+"s;"
                        var message = "Limiting time is "+value+" minutes"
                        window.alert(message);
                        // window.alert(value*10);
                        fill.style.cssText = time;
                        var count=0;
                    //通过间隔定时器实现百分比文字效果,通过计算CSS动画持续时间进行间隔设置
                        var timer=setInterval(function(e){
                            count++;
                            var index = count/1;
                            if(index <= 100)
                            fill.innerHTML=index+'%';
                            if(index==101){
                                clearInterval(timer);
                                window.alert("test ending");
                                var firstTest = "${requestScope.firstTest}";
                                // window.alert(firstTest);
                                if(firstTest=="true"){
                                    firstSubmit();
                                } else {
                                    secondSubmit();
                                }
                            }
                        },value*600);
                    }
                }
            };
    progressbar.init(false);

    function firstSubmit(){
        var form = document.forms[0];
        form.action = "firstSubmit?student_id=${student_id}&overtime=true";
        form.method="post";
        form.submit();
        <%--window.location.href="firstSubmit?student_id=${student_id}";--%>
    }
    function secondSubmit(){
        var form = document.forms[0];
        form.action = "secondSubmit?student_id=${student_id}";
        form.method="post";
        form.submit();
        <%--window.location.href="secondSubmit?student_id=${student_id}";--%>
    }

</script>

</body>

</html>
