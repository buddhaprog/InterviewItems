//function fillblogbody(data, status) {
//    clearblogs();
//    var bbody = $('#blogbody');
//    $.each(data, function (index, blog) {
//        var blogPar = truncBlog(blog.blog);
//        bbody.append($('<h2>').append($('<a>')
//                .text(blog.blogTitle)))
//                .append($('<p>')
//                        .html(blogPar))
//                .append($('<div>')
//                        .attr({'align': 'right'})
//                        .append($('<a>')
//                                .attr({'data-blog-id': blog.blogId, 'data-toggle': 'modal', 'data-target': '#editModal'})
//                                .text('Edit'))
//                        .append($('<a>')
//                                .attr({'onClick': 'deleteblog(' + blog.blogId + ')'})
//                                .text(' Delete'))
//                        )
//                .append($('<hr>'));
//    });
//}
//
//function truncBlog(blogBody) {
//    var n = blogBody.indexOf("</p>");
//    return blogBody.substr(0, n + 4);
//}
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
                .append($('<div>')
                        .attr({'align': 'right'})
                        .append($('<a>')
                                .attr({'data-blog-id': blog.blogId, 'data-toggle': 'modal', 'data-target': '#editModal'})
                                .text('Edit'))
                        .append($('<a>')
                                .attr({'onClick': 'deleteblog(' + blog.blogId + ')'})
                                .text(' Delete'))
                        )
                .append($('<hr>'));
    });
}

function blogDetail(blogId) {
    var element = $(event.relatedTarget);
    var blogId = element.data('blog-id');
    var blog = $(this);
    $.ajax({
        type: 'GET',
        url: 'blog/' + blogId
    }).success(function (blog) {
        blog.find('#blog-id').text(blog.blogId)
        blog.find('#blog-title').text(blog.blogTitle);
        blog.find('#blog-blog').text(blog.blog);
    });
}

function truncBlog(blogBody, blogId) {
    var n = blogBody.indexOf("</p>");
    var link = "<a onClick='" + 'location.href="blogdetailpage?blogId=' + blogId + '"' + "'>" + "... see more</a>";
    var showBlog = blogBody.substr(0, n + 4) + link;
    return showBlog;
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