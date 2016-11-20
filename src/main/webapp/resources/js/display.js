$(document).ready(function(){

    $("#dateFrom").datepicker();

    var itemsData = ua.demitt.fn.getItemsDataFromTable();
    ua.demitt.var.plotObject = ua.demitt.fn.plot(itemsData);

});



/*Variables*/


ua.demitt.var.plotObject = null;
ua.demitt.var.plotOptions = {
    yaxis: {
        min: 0,
        color: "#ABBBEB"
    },
    xaxis: {
        color: "#ABBBEB",
        mode: "time",
        timeformat: "%d.%m.%y",
        timezone: "browser",
        twelveHourClock: false
    },
    series: {
        color: "#425FDB",
        lines: {
            lineWidth: 1,
            fill: true,
            fillColor: "rgba(255, 255, 255, 0.5)"
            //steps: true
        }
    },
    grid: {
        backgroundColor: "#D9F3FF",
        borderWidth: 1,
        borderColor: "#8597E6"
    }
};


/*Functions*/


ua.demitt.fn.getItemsDataFromTable = function() {
    var data = [];
    $("#itemsTable").find("TR:gt(0)").each(function() {
        var value = parseInt($(this).find("TD:eq(2)").text());
        var dateInMilliseconds = parseInt($(this).find("SPAN").text()) * 24 * 3600 * 1000;
        data.push([dateInMilliseconds, value]);
    });
    return data;
};


ua.demitt.fn.changeDateHandler = function(data) {
    if (data.status != "success") {
        return;
    }
    var itemsData = ua.demitt.fn.getItemsDataFromTable();
    ua.demitt.fn.redraw(itemsData);

};


ua.demitt.fn.clearPlotHandler = function(data) {
    if (data.status != "success") {
        return;
    }
    ua.demitt.fn.clearPlot();
};


ua.demitt.fn.redrawPlotHandler = function(data) {
    if (data.status != "success") {
        return;
    }
    var itemsData = ua.demitt.fn.getItemsDataFromTable();
    ua.demitt.fn.redraw(itemsData);
};


ua.demitt.fn.plot = function(itemsData) {
    return $.plot($("#plotter"), [itemsData], ua.demitt.var.plotOptions);
};


ua.demitt.fn.redraw = function(itemsData) {
    ua.demitt.var.plotObject.setData([itemsData]);
    ua.demitt.var.plotObject.setupGrid();
    ua.demitt.var.plotObject.draw();
};


ua.demitt.fn.clearPlot = function() {
    ua.demitt.var.plotObject.setData([]);
    ua.demitt.var.plotObject.draw();
};
