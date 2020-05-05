$(document).ready(function(){
    $('input[name="propertyType"]').click(function(){
        var inputValue = $(this).attr("value");
        var targetBox = $("." + inputValue);
        $(".box").not(targetBox).hide();
        $(targetBox).show();
    });
});

$(document).ready(function(){
    $('input[name="reBuildingType"]').click(function(){
        var inputValue = $(this).attr("value");
        var targetBox = $("." + inputValue);
        $(".box2").not(targetBox).hide();
        $(targetBox).show();
    });
});

$(document).ready(function(){
    $('input[name="comBuildingType"]').click(function(){
        var inputValue = $(this).attr("value");
        var targetBox = $("." + inputValue);
        $(".box3").not(targetBox).hide();
        $(targetBox).show();
    });
});

$(document).ready(function(){
    $('input[name="propertyList"]').click(function(){
        var inputValue = $(this).attr("value");
        var targetBox = $("." + inputValue);
        $(".box4").not(targetBox).hide();
        $(targetBox).show();
    });
});



$(document).ready(function() {
$(".next").click(function() { // Function Runs On NEXT Button Click
$(this).parent().next().fadeIn('slow');
$(this).parent().css({
'display': 'none'
});
// Adding Class Active To Show Steps Forward;
$('.progress').next().addClass('active');
});
$(".previous").click(function() { // Function Runs On PREVIOUS Button Click
$(this).parent().prev().fadeIn('slow');
$(this).parent().css({
'display': 'none'
});
// Removing Class Active To Show Steps Backward;
$('.active:last').removeClass('active');
});
// Validating All Input And Textarea Fields
$(".submit_btn").click(function(e) {
if ($('input').val() == "" || $('textarea').val() == "") {
alert("*All Fields are mandatory*");
return false;
} else {
return true;
}
});
});