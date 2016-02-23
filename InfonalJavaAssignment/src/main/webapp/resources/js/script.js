$( document ).ready(function() {

        //User Register Button Click Event
        $(document).on('click', '.btn-save', function () {
            var userName = $("#name-input").val();
            var surName = $("#surname-input").val();
            var phoneNumber = $("#phonenumber-input").val();

      //      console.log("userName :" +userName + "surName :"  +surName +  "phoneNumber :" +phoneNumber);
            if (userName == "" || surName == "") {
                alert("All field must be field.")
            } else {
                $('.load').show();
                $.ajax({
                    url: "/InfonalJavaAssignment/user/save",
                    type: "post",
                    data: $('.form-save-user').serialize(),

                    success: function (data) {

                     //   console.log(data);

                        location.reload();
                        $('.load').hide(1000);
                    }
                });
            }
        });
         //User Delete Button Click Event
        $(document).on('click', '.btn-delete-trigger', function () {
            var $this = $(this)
            var _userId = $this.attr("data-id");
            $('.load').show();
            $.ajax({
                url: "/InfonalJavaAssignment/user/delete/" + _userId,
                type: "delete",
                data: {id: _userId},


                success: function (data) {

                    $("#myModal").modal("hide");
                    $('.load').hide();
                    $(".person-table-list tr[data-id=" + _userId + "]").hide("fast");

                },
                error: function (data) {
                    alert(data);
                }
            });
        });

        //User Update Button Click Event
        $(document).on('click', '.btn-update-trigger', function () {
            $('.load').show();
            $.ajax({
                url: "/InfonalJavaAssignment/user/update",
                type: "post",
                data: $('.form-update-person').serialize(),

                success: function (data) {
                    location.reload();
                }
            });

        });

         //User Update Modal Click Event
        $(document).on('click','.btn-update-modal', function () {
                var $this = $(this);
                var id = $this.attr("data-id");
                var name = $this.attr("data-name");
                var surname = $this.attr("data-surname");
                var phoneNumber = $this.attr("data-phonenumber");

                $('#new-id-input').val(id) ;
                $('#new-name-input').val(name);
                $('#new-surname-input').val(surname);
                $('#new-phonenumber-input').val(phoneNumber);

            });


        //User Delete Button Click Event
        $(document).on('click','.btn-delete-modal', function () {
                var $this = $(this);

                var _name = $this.attr("data-name");

                var _surname = $this.attr("data-surname");

                $("#myModal .modal-clone-content").html("<span>" + _name + " " + _surname + "</span>");

                $(".btn-delete-trigger").attr("data-id",$this.attr("data-id"));

                $("#myModal").modal("show");

            });


        $(document).on('click', '#phonenumber-input', function () {
                $("#phonenumber-input").mask("9(999)-999-99-99");

            });


});
