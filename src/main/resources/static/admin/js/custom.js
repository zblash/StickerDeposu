$(document).ready(function () {

    $("#getPhotos").on("click", function (event) {

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        event.preventDefault();
        $.ajax({
            type: "POST",
            beforeSend: function(request) {
                request.setRequestHeader(header, token);
            },
            url: "/photos",
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                data.forEach(function (entry) {
                    $("#selectPhoto").prepend(`<div class="modal-photo-div" id="photos-${entry.id}"><img src="/uploads/${entry.directory}" /></div>`)
                })
            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });
    });
    $("#addphoto").submit(function (event) {

        event.preventDefault();

        fire_ajax_submit();

    });
    $(document).on("click", ".modal-photo-div", function () {
        if ($(this).hasClass("modal-photo-div-selected")) {
            $("#productPhoto").val('')
            $(".modal-photo-div-selected").removeClass("modal-photo-div-selected");
        } else {
            $(".modal-photo-div-selected").removeClass("modal-photo-div-selected");

            var img = $(this).find('img').attr('src');
            imgDir = img.split("/uploads/").pop()
            $(this).addClass("modal-photo-div-selected")
            $("#productPhoto").val(imgDir)
            if ($("#theImg").length > 0) {
                $("#theImg").attr('src', img);
            } else {
                $("#displayPhoto").prepend(`<img id="theImg" src="${img}" />`)
            }
        }
    })
});

function fire_ajax_submit() {
    var form = $('#addphoto')[0];
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    var data = new FormData(form);

    $.ajax({
        type: "POST",
        beforeSend: function(request) {
            request.setRequestHeader(header, token);
        },
        enctype: 'multipart/form-data',
        url: "/photo/add",
        processData: false,
        contentType: false,
        cache: false,
        data: data,
        timeout: 600000,
        success: function (data) {
            $('#photoModal').modal('hide');
            if ($("#theImg").length > 0) {
                $("#theImg").attr('src', `/uploads/${data}`);
            } else {
                $("#displayPhoto").prepend(`<img id="theImg" src="/uploads/${data}" />`)
            }
            $("#productPhoto").val(data)
        },
        error: function (e) {

            console.log("ERROR : ", e);

        }
    });

}