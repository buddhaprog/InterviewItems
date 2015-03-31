function fillBlogTable(blogList, status) {
    clearblogs();
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
                                .attr({
                                    'onClick': 'deleteBlog(' + blog.blogId + ')'
                                })
                                .text('Delete')
                                )
                        )
                );
    });
}