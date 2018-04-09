var basic_part_url = 'http://localhost:8080/clinic';

function currentUser() {
    $.ajax({
        url: basic_part_url + "/current",
        method: 'GET',
        success: function (data) {
            if (data !== null && data.name !== undefined) {
                closeDialog(data);
            }
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

function closeDialog(data) {
    var name = data.name[0].toUpperCase() + data.name.slice(1);
    $('#logout-item').show();
    $('#login-item').hide();
    $('#user-info').html(name);
    if (data.role === "admin") {
        $('#add-blog').show();
        $('#add-procedure').show();
        $('#admin-page-id').show();
    }
}

function createBlog() {
    $.ajax({
        url: basic_part_url + '/create-blog',
        method: "POST",
        data: {"title": $("#title").val(), "desc": $("#description").val(), "content": $("#content").val()},
        success: function () {
            location.reload();
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

function createProcedure() {
    $.ajax({
        url: basic_part_url + '/create-procedure',
        method: "POST",
        data: {
            "name": $("#procedure-name").val(),
            "description": $("#procedure-desc").val(),
            "price": $("#price").val()
        },
        success: function (data) {
            location.reload();
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

function updateUser(userId) {
    var firsName = $("#firstName").val();
    var lastName = $("#lastName").val();
    var phoneNumber = $("#phone").val();

    if (firsName !== "" && lastName !== "" && phoneNumber !== "") {
        $.ajax({
            url: basic_part_url + '/update-user',
            method: "POST",
            data: {
                "id": userId,
                "firstName": firsName,
                "lastName": lastName,
                "phoneNumber": phoneNumber
            },
            success: function (data) {
                location.reload();
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });
    } else {
        alert("Fill all field");
    }
}

function loadProcedure() {
    $("#phone").empty();
    $.ajax({
        url: basic_part_url + '/procedures',
        method: "GET",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                document.getElementById("phone").innerHTML += "<option value='"
                    + data[i].name + "'>" + data[i].name +
                    "</option>";
            }
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

function omgtest(petId) {
    $.ajax({
        url: basic_part_url + '/add-procedure-to-pet',
        method: "POST",
        data: {"petId": petId, "name": $("#phone" + petId).val()},
        success: function (data) {
            // location.reload();
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}
