$(document).ready(function () {
    //获取div区域
    var $opt_area = $("#opt_area");
    function initNews() {
        $opt_area.load("/util/news", "opr=listHtml"); // load(请求地址，请求参数)
    }
    initNews();
    
    function initTopics() {//获取所以主题数据
        $opt_area.load("/util/topics", "opr=listHtml");
    }
    //获取左边的超链接
    var $leftLink = $("#opt_list a");
    //给第四个超链接绑定点击事件
    $leftLink.eq(3).click(initTopics);

    //点击第三个超链接，添加主题
    $leftLink.eq(2).click(function () {
        $opt_area.load("/newspages/topic_add.jsp #opt_area>*")
    })

    //获取提示信息的div,#msg
    var $msg = $("#msg");
    //on绑定事件
    $opt_area.on("click", "#addTopicSubmit", function () {
        var $tname = $opt_area.find("#tname");//获取主题文本框
        var tnameValue = $tname.val();//获取用户输入的主题
        if(tnameValue == "") {
            $msg.html("请输入主题名称！").fadeIn(1000).fadeOut(5000);
            $tname.focus();
            return false;
        }
        //ajax处理请求方法，load.getJSON,post,get方法
        $.getJSON("/util/topics", "opr=add&tname="+tnameValue, addTopics);
        function addTopics(data) {//根据后端json，显示
            if(data[0].status == "success") {
                //添加成功
                $msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
                $opt_area.load("/util/topics", "opr=listHtml");
            }else if(data[0].status == "exist") {
                //已经存在
                $msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
                $tname.select();
            }else if(data[0].status == "error") {
                //加载主题数据
                $msg.html(data[0].message).fadeIn(1000).fadeOut(5000);
                $opt_area.load("/util/topics", "opr=listHtml");
            }
        }
        }
    );
})