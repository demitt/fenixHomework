$(document).ready(function(){

    //Default-options fow all datepicker fields;
    $.fn.datepicker.defaults.format = "dd-mm-yyyy"; //according Java Const.ITEM_DATE_FORMATTER format
    $.fn.datepicker.defaults.weekStart = 1;
    $.fn.datepicker.defaults.maxViewMode = 3;
    $.fn.datepicker.defaults.daysOfWeekHighlighted = "6,0";
    $.fn.datepicker.defaults.autoclose = true;
    $.fn.datepicker.defaults.todayHighlight = true;

});



if (!ua) {
    var ua = {};
}
if (!ua.demitt) {
    ua.demitt = {};
}
if (!ua.demitt.fn) {
    ua.demitt.fn = {};
}
if (!ua.demitt.var) {
    ua.demitt.var = {};
}
