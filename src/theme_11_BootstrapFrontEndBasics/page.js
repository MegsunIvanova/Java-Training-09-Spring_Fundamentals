$(document).ready(function() {
   $('#my-button').click(function () {
       // console.log("Button clicked")
       $('#my-text').text('My custom text')
       $('#my-text').addClass("text-primary")
   })
});

function myCustomClick () {
    console.log("Custom click")
}