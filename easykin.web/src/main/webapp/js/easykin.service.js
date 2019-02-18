$( document ).ready(
$(function () {
    $('#addRateBtn').click(function () {
        $('#addRateDiv').show()
    })

    $('#services').DataTable()

    var barChartData = {
      labels  : ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
      datasets: [
/*        {
          label               : '2017',
          fillColor           : '#00a65a',
          strokeColor         : '#00a65a',
          pointColor          : '#00a65a',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data                : [5146.78, 5031.61, 5291.60, 4401.07, 3762.17, 4185.63, 4113.96, 4223.81, 4412.46, 4523.19, 4686.04, 4621.23]
        },
*/
        {
          label               : '2018',
          fillColor           : '#00a65a',
          strokeColor         : '#00a65a',
          pointColor          : '#00a65a',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data                : [4760.06, 4779.48, 4900.75, 4967.82, 4707.71, 4967.82, 4482.05, 5019.84, 4754.35, 4752.53, 4827.94, 5026.65]
        },
         {
           label               : '2019',
           fillColor           : 'rgba(60,141,188,0.9)',
           strokeColor         : 'rgba(60,141,188,0.8)',
           pointColor          : '#3b8bba',
           pointStrokeColor    : 'rgba(60,141,188,1)',
           pointHighlightFill  : '#fff',
           pointHighlightStroke: 'rgba(60,141,188,1)',
           data                : [4234.87, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]
         }

      ]
    }

    //-------------
    //- BAR CHART -
    //-------------
    var barChartCanvas               = $('#barChart').get(0).getContext('2d')
    var barChart                     = new Chart(barChartCanvas)
    var barChartOptions              = {
      //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
      scaleBeginAtZero        : true,
      //Boolean - Whether grid lines are shown across the chart
      scaleShowGridLines      : true,
      //String - Colour of the grid lines
      scaleGridLineColor      : 'rgba(0,0,0,.05)',
      //Number - Width of the grid lines
      scaleGridLineWidth      : 1,
      //Boolean - Whether to show horizontal lines (except X axis)
      scaleShowHorizontalLines: true,
      //Boolean - Whether to show vertical lines (except Y axis)
      scaleShowVerticalLines  : true,
      //Boolean - If there is a stroke on each bar
      barShowStroke           : true,
      //Number - Pixel width of the bar stroke
      barStrokeWidth          : 2,
      //Number - Spacing between each of the X value sets
      barValueSpacing         : 5,
      //Number - Spacing between data sets within X values
      barDatasetSpacing       : 1,
      //Boolean - whether to make the chart responsive
      responsive              : true,
      maintainAspectRatio     : true
    }

    barChartOptions.datasetFill = false
    barChart.Bar(barChartData, barChartOptions)
})
);