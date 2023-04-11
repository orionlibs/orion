var chartCurvedLineOptions =
{
    series:
    {
        shadowSize: 0,
        curvedLines:
        {
            apply: true,
            active: true,
            monotonicFit: true
        },
        points:
        {
            show: false
        }
    },
    grid:
    {
        borderWidth: 1,
        borderColor: 'rgba(255,255,255,0.4)',
        show: true,
        hoverable: true,
        clickable: true
    },
    xaxis:
    {
        tickColor: 'rgba(255,255,255,0.25)',
        tickDecimals: 0,
        font:
        {
            lineHeight: 13,
            style: 'normal',
            color: 'rgba(255,255,255,0.8)',
            size: 11
        },
        mode: "time",
        //timeBase: "seconds",
        timeformat: "%d/%m/%Y"
    },
    yaxis:
    {
        tickColor: 'rgba(255,255,255,0.25)',
        font:
        {
            lineHeight: 13,
            style: 'normal',
            color: 'rgba(255,255,255,0.8)',
            size: 11
        },
        min: +5
    },
    legend:
    {
        container: '.flot-chart-legends',
        backgroundOpacity: 0.5,
        noColumns: 0,
        lineWidth: 0,
        labelBoxBorderColor: 'rgba(255,255,255,0.75)'
    }
};


var chart = 
{
    getTimeseriesChartData : function(data, chartLabel)
    {
        var chartCurvedLineData =
        [{
            label: chartLabel,
            color: 'rgba(255,255,255,1)',
            lines:
            {
                show: true,
                lineWidth: 0.1,
                fill: 1,
                fillColor:
                {
                    colors: ['rgba(255,255,255,0.01)', '#fff']
                }
            },
            data: eval(data)
        }];
        
        
        return chartCurvedLineData;
    }
};