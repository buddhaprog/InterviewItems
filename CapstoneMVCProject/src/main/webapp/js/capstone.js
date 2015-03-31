$(document).ready(function () {

    loadblogs();
    loadallblogs();
    loadUnpostedblogs();
    loadUsers();
    loadPages();
    loadPostedPages();

    //active nav bar stuff
    var url = window.location;
    $('ul.nav a[href="' + url + '"]').parent().addClass('active');
    $('ul.nav a').filter(function () {
        return this.href == url;
    }).parent().addClass('active');

    $('#new-user-submit-button').click(function (event) {
//        event.preventDefault();
        var form = $('#registerform');
        var isvalid = checkForm(form);
        if (isvalid === false) {
            event.preventDefault();
        } else {
            $.ajax({
                type: 'POST',
                url: 'user',
                data: JSON.stringify({
                    firstName: $('#add-first-name').val(),
                    lastName: $('#add-last-name').val(),
                    email: $('#add-email').val(),
                    userName: $('#add-user-name').val(),
                    password: $('#add-password').val()
                }),
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'dataType': 'json'
            }).success(function () {
                $('#add-first-name').val('');
                $('#add-last-name').val('');
                $('#add-email').val('');
                $('#add-user-name').val('');
                $('#add-password').val('');
                $('#add-password2').val('');
            });
        }
    });
    $('#edit-user-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'PUT',
            url: 'user/' + $('#edit-user-id').val(),
            data: JSON.stringify({
                userId: $('#edit-user-id').val(),
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                userName: $('#edit-user-name').val(),
                email: $('#edit-email').val(),
                enabled: $('#edit-enabled').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadUsers();
        });
    });

    $('#search-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/users',
            data: JSON.stringify({
                firstName: $('#search-first-name').val(),
                lastName: $('#search-last-name').val(),
                userName: $('#search-user-name').val(),
                email: $('#search-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#search-first-name').val('');
            $('#search-last-name').val('');
            $('#search-user-name').val('');
            $('#search-email').val('');

            fillUserTable(data, status);
        });
    });

    $('#pager').click(function (event) {
        event.preventDefault();
        nextblog();
        previousblog();
    }
    );
    //add page button
    $('#page-add-button').click(function (event) {
        event.preventDefault();
        savePages();
    });

    //edit page button
    $('#page-edit-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'PUT',
            url: 'page/' + $('#edit-page-id').val(),
            data: JSON.stringify({
                pageId: $('#edit-page-id').val(),
                pageTitle: $('#edit-title').val(),
                posted: $('#edit-posted').val(),
                pageBody: (tinyMCE.activeEditor.getContent())
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadPages();
            loadPostedPages();
        });
    });


    //delete page button
    $('#page-delete-button').click(function (event) {
        alert('Are you sure?');
    }
    );

    //post page button
    $('#page-post-button').click(function (event) {
        alert('Are you sure?');

    }
    );


//unpost page button
    $('#page-unpost-button').click(function (event) {
        alert('Are you sure?');
    }
    );

    //add blog button
    $('#blog-add-button').click(function (event) {
        event.preventDefault();
        saveblogs();
    });

    //blog edit button
    $('#blog-edit-button').click(function (event) {
        event.preventDefault();
//        editBlog();
        $.ajax({
            type: 'PUT',
            url: 'blog/' + $('#edit-blog-id').val(),
            data: JSON.stringify({
                blogId: $('#edit-blog-id').val(),
                blogTitle: $('#edit-title').val(),
//                blogDate: $('#edit-blog-date').val(),
                userId: $('#edit-user-id').val(),
                posted: $('#edit-posted').val(),
                blog: (tinyMCE.activeEditor.getContent())
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadblogs();
            loadallblogs();
            loadUnpostedblogs();
        });
    });


//remove blog button
    $('#blog-delete-button').click(function (event) {
        alert('Are you sure?');
    }
    );

//post blog button
    $('#blog-post-button').click(function (event) {
        event.preventDefault();
        saveblogs();
//        window.location.href = "/CapstoneMVCProject/blogsummarypage";
    }
    );

//unpost blog button
    $('#blog-unpost-button').click(function (event) {
        alert('Are you sure?');
    }
    );

    //delete comment button
    $('#comment-delete-button').click(function (event) {
    }
    );



//new user button
    $('#add-user-button').click(function (event) {

    }
    );

    //add comment button
    $('#comment-add-button').click(function (event) {
    }
    );


    $('#login-modal-button').click(function (event) {
        event.preventDefault();
        $('#login-modal').modal('show');

    });

//search button
    $('#search-button').click(function (event) {

    });


//LOGIN user stuff$('#new-user-submit-button').on('submit', function (event) {
//    $('#new-user-submit-button').click(function (event) {
//
//        var form = $('#registerform');
//        var isvalid = checkForm(form);
//        if (isvalid === false) {
//            event.preventDefault();
//        }
//    });





});
//BLOG FUNCTIONS GO HERE!!!!
function saveblogs() {

    $.ajax({
        type: 'POST',
        url: 'blog',
        data: JSON.stringify({
            blogTitle: $('#title').val(),
            blog: (tinyMCE.activeEditor.getContent())
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        $('#title').val('');
        tinymce.init({selector: '#blogtext'});
        tinymce.activeEditor.setContent('');
    });
}


//load blog
function loadblogs() {
    $.ajax({
        url: 'postedBlogs'
    }).success(function (data, status) {
        fillblogbody(data, status);
        fillSideBar(data, status);
//        fillBlogTable(data, status);

    });
}
function loadUnpostedblogs() {
    $.ajax({
        url: 'unpostedBlogs'
    }).success(function (data, status) {
        fillUnpostedSideBar(data, status);
    });
}


function loadallblogs() {
    $.ajax({
        url: 'blogs'
    }).success(function (data, status) {
//        fillblogbody(data, status);
//        fillSideBar(data, status);
        fillBlogTable(data, status);

    });
}

function fillblogbody(data, status) {
    clearblogs();
    var bbody = $('#blogbody');
    $.each(data, function (index, blog) {
        var blogPar = truncBlog(blog.blog, blog.blogId);
        bbody.append($('<h2>').append($('<a>')
//                .attr({'onClick': 'blogDetail(' + blog.blogId + ')'})
                .attr({'onClick': "location.href='blogdetailpage?blogId=" + blog.blogId + "'"})
                .text(blog.blogTitle)))
                .append($('<p>')
                        .html(blogPar))
//                .append($('<div>')
//                        .attr({'align': 'right'})
//                        .append($('<a>')
//                                .attr({'data-blog-id': blog.blogId, 'data-toggle': 'modal', 'data-target': '#editModal'})
//                                .text('Edit'))
//                        .append($('<a>')
//                                .attr({'onClick': 'deleteblog(' + blog.blogId + ')'})
//                                .text(' Delete'))
//                        )
                .append($('<hr>'));
    });
}

function fillBlogTable(blogList, status) {
    clearBlogTable();
    var bTable = $('#blogRows');
    $.each(blogList, function (index, blog) {
        bTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({'onClick': "location.href='blogdetailpage?blogId=" + blog.blogId + "'"})
                                .text(blog.blogTitle)
                                )
                        )
                .append($('<td>')
                        .append($('<a>')
                                .attr({'data-blog-id': blog.blogId, 'data-toggle': 'modal', 'data-target': '#editModal'})
                                .text('Edit')
                                )
                        )
                .append($('<td>')
                        .append($('<a>')
                                .attr({'onClick': 'deleteblog(' + blog.blogId + ')'})
                                .text('Delete')
                                )
                        )
                .append($('<td>')
                        .append($('<a>')
                                .attr({'onClick': 'postBlog(' + blog.blogId + ',' + blog.posted + ')'})
                                .text(blog.posted)
                                )
                        )
                );
    });
}

//clear blog
function clearblogs() {
    $('#blogbody').empty();
}
function clearBlogTable() {
    $('#blogRows').empty();
}

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var blogId = element.data('blog-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'blog/' + blogId
    }).success(function (blog) {
        modal.find('#blog-id').text(blog.blogId);
        modal.find('#edit-blog-id').val(blog.blogId);
        modal.find('#edit-title').val(blog.blogTitle);
        modal.find('#edit-blog-date-show').val(blog.blogDate.monthValue + '/' + blog.blogDate.dayOfMonth + '/' + blog.blogDate.year);
//        modal.find('#edit-blog-date').val(blog.blogDate.year + '/' + blog.blogDate.monthValue + '/' + blog.blogDate.dayOfMonth);
//        modal.find('#edit-blog-date').val(blog.blogDate);
        modal.find('#edit-user-id').val(blog.userId);
        modal.find('#edit-posted').val(blog.posted);
//        modal.find('#edit-blogtext').html(blog.blog);
//        modal.find(tinyMCE.get('#edit-blogtext').(blog.blog)));
        tinyMCE.activeEditor.setContent(blog.blog);
    });
});

//remove blog function
function deleteblog(blogId) {
    var answer = confirm("Confirm?");

    if (answer) {
        $.ajax({
            type: 'DELETE',
            url: 'blog/' + blogId
        }).success(function () {
            loadallblogs();
            loadblogs();
            loadUnpostedblogs();
        });
    }
}

function postBlog(blogId, posted) {

    if (posted) {
        $.ajax({
            type: 'PUT',
            url: 'unpostblog/' + blogId
        }).success(function () {
            loadallblogs();
            loadblogs();
            loadUnpostedblogs();
        });
    } else {
        $.ajax({
            type: 'PUT',
            url: 'postblog/' + blogId
        }).success(function () {
            loadallblogs();
            loadblogs();
            loadUnpostedblogs();
        });
    }
}

function truncBlog(blogBody, blogId) {
    var n = blogBody.indexOf("</p>");
    var link = "<a onClick='" + 'location.href="blogdetailpage?blogId=' + blogId + '"' + "'>" + "... see more</a>";
    var showBlog = blogBody.substr(0, n + 4) + link;
    return showBlog;
}

//USER FUNCTIONS
function adduser() {
    $('#addusermodal').modal('show');
}

function loadUsers() {
    $.ajax({
        url: 'users'
    }).success(function (data, status) {
        fillUserTable(data, status);
//        $.ajax({
//            url: 'numContacts'
//        }).success(function (numContacts, status) {
//            $('#num-contacts').text(numContacts + ' Contacts in the database');
//        });
    });
}

function fillUserTable(userList, status) {
    //    clear the table so you don't repeat information
    clearUserTable();
//grab html element into which we are going to write the data
    var uTable = $('#contentRows');
    $.each(userList, function (index, user) {
        uTable.append($('<tr>')
                .append($('<td>')
//        Dont have to clear the modal after each and every time, when dismissed the content goes away
                        .append($('<a>')
                                .attr({'data-user-id': user.userId, 'data-toggle': 'modal', 'data-target': '#detailsModal'})
                                .text(user.firstName + ' ' + user.lastName)
                                )
                        )
                .append($('<td>').text(user.userName))
//                .append($('<td>').text(user.authority))
                .append($('<td>').text(user.email))
                .append($('<td>')
                        .append($('<a>')
                                .attr({'data-user-id': user.userId, 'data-toggle': 'modal', 'data-target': '#editUserModal'})
                                .text('Edit')
                                )
                        )
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteUser(' + user.userId + ')'
                                })
                                .text('Delete')
                                )
                        )
                );
    });
}

function clearUserTable() {
    $('#contentRows').empty();
}
$('#detailsModal').on('show.bs.modal', function (event) {
//get the element that triggered the event
//the anchor is the element/relatedTarget that is clicked on
//UI is event driven programming, it sits there and waaits for something to happen
    var element = $(event.relatedTarget);
    var userId = element.data('user-id');
//    PLACEHOLDER - use dummy data for now
//  Called detailsModal about, and now you're putting it into the variable
    var modal = $(this);
//      make an ajax call to get contact information for given contact
    $.ajax({
        type: 'GET',
        url: 'user/' + userId
    }).success(function (user) {
        modal.find('#user-id').text(user.userId);
        modal.find('#user-first-name').text(user.firstName);
        modal.find('#user-last-name').text(user.lastName);
        modal.find('#user-user-name').text(user.userName);
        modal.find('#user-email').text(user.email);
        modal.find('#user-enabled').text(user.enabled);
    });
});
//this code runs in response to the show.bs.modaal event for the edit modal
$('#editUserModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var userId = element.data('user-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'user/' + userId

    }).success(function (user) {

        modal.find('#user-id').text(user.userId);
        modal.find('#edit-user-id').val(user.userId);
        modal.find('#edit-first-name').val(user.firstName);
        modal.find('#edit-last-name').val(user.lastName);
        modal.find('#edit-user-name').val(user.userName);
        modal.find('#edit-email').val(user.email);
        modal.find('#edit-enabled').val(user.enabled);
    });
});

function deleteUser(userId) {
    var answer = confirm("Confirm?");

    if (answer) {
        $.ajax({
            type: 'DELETE',
            url: 'user/' + userId
        }).success(function () {
            loadUsers();
        });
    }
}

//PAGE FUNCTIONS
function savePages() {
    $.ajax({
        type: 'POST',
        url: 'page',
        data: JSON.stringify({
            pageTitle: $('#page-title').val(),
            pageBody: (tinyMCE.activeEditor.getContent())
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        $('#page-title').val('');
        tinyMCE.init({selector: '#page-body'});
        tinyMCE.activeEditor.setContent('');
    });
}

function loadPostedPages() {
    $.ajax({
        url: 'postedPages'
    }).success(function (data, status) {
        fillStaticPages(data, status);
    });
}

function loadPages() {
    $.ajax({
        url: 'pages'
    }).success(function (data, status) {
        fillPageTable(data, status);
    });
}


function fillPageTable(pageList, status) {
    clearPages();
    var pTable = $('#pageRows');
    $.each(pageList, function (index, page) {
        pTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({'onClick': "location.href='pagedetailpage?pageId=" + page.pageId + "'"})
                                .text(page.pageTitle)
                                )
                        )
                .append($('<td>')
                        .append($('<a>')
                                .attr({'data-page-id': page.pageId, 'data-toggle': 'modal', 'data-target': '#editPageModal'})
                                .text('Edit')
                                )
                        )
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deletePage(' + page.pageId + ')'
                                })
                                .text('Delete')
                                )
                        )
                .append($('<td>')
                        .append($('<a>')
                                .attr({'onClick': 'postPage(' + page.pageId + ',' + page.posted + ')'})
                                .text(page.posted)
                                )
                        )
                );
    });
}

function postPage(pageId, posted) {

    if (posted) {
        $.ajax({
            type: 'PUT',
            url: 'unpostpage/' + pageId
        }).success(function () {
            loadPostedPages();
            loadPages();
        });
    } else {
        $.ajax({
            type: 'PUT',
            url: 'postpage/' + pageId
        }).success(function () {
            loadPostedPages();
            loadPages();
        });
    }
}

function fillStaticPages(pageList, status) {
    clearStaticPages();
    var pTable = $('#static-pages');
    $.each(pageList, function (index, page) {
        pTable.append($('<li>')
                .append($('<a>')
                        .attr({'onClick': "location.href='pagedetailpage?pageId=" + page.pageId + "'"})
                        .text(page.pageTitle)
                        )
                );
    });
}

function fillSideBar(blogList, status) {
    clearSideBar();
    var bTable = $('#blogtable');
    $.each(blogList, function (index, blog) {
        bTable.append($('<li>')
                .append($('<a>')
                        .attr({'onClick': "location.href='blogdetailpage?blogId=" + blog.blogId + "'"})
                        .text(blog.blogTitle)
                        )
                );
    });
}

function fillUnpostedSideBar(blogList, status) {
    clearUnpostedSideBar();
    var bTable = $('#unpostedblogtable');
    $.each(blogList, function (index, blog) {
        bTable.append($('<li>')
                .append($('<a>')
                        .attr({'onClick': "location.href='blogdetailpage?blogId=" + blog.blogId + "'"})
                        .text(blog.blogTitle)
                        )
                );
    });
}

function clearPages() {
    $('#pageRows').empty();
}
function clearStaticPages() {
    $('#static-pages').empty();
}
function clearSideBar() {
    $('#blogtable').empty();
//    $('#unpostedblogtable').empty();
}

function clearUnpostedSideBar() {
//    $('#blogtable').empty();
    $('#unpostedblogtable').empty();
}

$('#pageLoader').click(function () {
    var element = $(event.relatedTarget);
    var pageId = element.data('page-id');
    var page = $(this);
    $.ajax({
        type: 'GET',
        url: 'page/' + pageId
    }).success(function (page) {
        page.find('#page-id').text(page.pageId);
        page.find('#page-title').text(page.pageTitle);
        page.find('#page-page-body').text(page.pageBody);
    });
});

$('#editPageModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var pageId = element.data('page-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'page/' + pageId
    }).success(function (page) {
        modal.find('#page-id').text(page.pageId);
        modal.find('#edit-page-id').val(page.pageId);
        modal.find('#edit-title').val(page.pageTitle);
        modal.find('#edit-posted').val(page.posted);
        tinyMCE.activeEditor.setContent(page.pageBody);
    });
});

function deletePage(pageId) {
    var answer = confirm("Confirm?");
    if (answer) {
        $.ajax({
            type: 'DELETE',
            url: 'page/' + pageId
        }).success(function () {
            loadPages();
        });
    }
}


function checkForm(form) {
    var pwd1 = $('#add-password').val();
    var pwd2 = $('#add-password2').val();
    var first = $('#add-first-name').val();
    var last = $('#add-last-name').val();
    var email = $('#add-email').val();
    var user = $('#add-user-name').val();

    if (first.length > 0 && last.length > 0 && email.length > 0 && user.length > 0) {
        if (pwd1 === pwd2) {
            re = /[0-9]/;
            if (!re.test(pwd1)) {
                alert("Error: password must contain at least one number (0-9)!");
                $('#add-password').focus();
                return false;
            }
            re = /[a-z]/;
            if (!re.test(pwd1)) {
                alert("Error: password must contain at least one lowercase letter (a-z)!");
                $('#add-password').focus();
                return false;
            }
            re = /[A-Z]/;
            if (!re.test(pwd1)) {
                alert("Error: password must contain at least one uppercase letter (A-Z)!");
                $('#add-password').focus();
                return false;
            }
            if (pwd1 === "") {
                alert("Error: Please check that you've entered and confirmed your password!");
                $('#add-password').focus();
                return false;
            }
            if (pwd1.length < 6) {
                alert("Error: Password to short!");
                $('#add-password').focus();
                return false;
            }
//        alert("You entered a valid password: " + $('#add-password').val());
            return true;
        } else {
            alert("Your password and confirmation do not match!");
            return false;
        }
    } else {
        return false;
    }
}
;


//COMMENT FUNCTIONS


//MISC FUNCTIONS

