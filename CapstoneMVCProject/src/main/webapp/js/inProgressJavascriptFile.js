$(document).ready(function () {


});




//PAGE ITEM FUNCTIONS!!!
//load page
function loadpages() {
}

//clear page
function clearpages() {
}

//add page function
function addpage() {
}

//edit page function
function editpage() {
}

//remove page function
function deletepage() {
}

//post page function
function postpage() {
}

//unpost page function
function unpostpage() {

}


//BLOG ITEM FUNCTIONS!!!!
function nextblog() {
}

function previousblog() {
}


//post blog function
function postblog() {
}


//unpost blog function
function unpostblog() {

}


//var sort_by = function(field, reverse, primer){
//
//   var key = primer ? 
//       function(x) {return primer(x[field]);} : 
//       function(x) {return x[field];};
//
//   var reverse = !reverse ? 1 : -1;
//
//   return function (a, b) {
//       return a = key(a), b = key(b), reverse * ((a > b) - (b > a));
//     } 
//}
function sortblogbydate(a, b) {
    return parseLocalDate(a["blogDate"]) - parseLocalDate(b["blogDate"]);
}
function getlastfiveblogs(){
 var blogdatelist = {"blogs": [Blog]};
    blogdatelist["blogs"].sort(sortblogbydate);
    var blogdatearray=[];
    var blogdatearraylength=5;
    
    var recent1=blogdatearray[0];
    var recent2=blogdatearray[1];
    var recent3=blogdatearray[2];
    var recent4=blogdatearray[3];
    var recent5=blogdatearray[4];
    
    for(var i=0;i<blogdatearraylength;i++){
        
    }
    
    
    }

//load recent blog table
function fillblogtable() {
   
    // clear the table so we don't repeat information
    clearBlogTable();
    var blogtable = $('#blogtable');
    // grab HTML element into which we're going to load the data
    var recentnumber = 0;
    var bList = $('#recent' + recentnumber++);

    // iterate through each of the JSON objects in the test data and render
    // them into the list
    $.ajax({
        url: 'blogs'
    }).success(function (data, status) {
        do {
            $.ajax({
                url: '/sidebarfragment'
            }).success(function (data, status) {
                $.each(data, function (index, blog) {
                    bList.append($('ol')
                            .append($('li')
                                    .append($('<a>')
                                            .attr({'data-blog-id': blog.blogId,'data-target': '#blogtable'})
                                            .text(blog.blogTitle)
                                            )
                                    )
                            );
                });

            });
            recentnumber++;
        } while (recentnumber < 5 + 1);
    });
}
//get blog date range function



//clear recent blog table
function clearblogtable() {
    $('#blogtable').empty();
}

//COMMENT FUNCTIONS GO HERE!!!
//add comment function
function addcomment() {
}

//delete comment function
function deletecomment() {
}

//USER FUNCTIONS GO HERE!!!
////new user function
//function adduser() {
//    $('#addusermodal').modal('show');
//
//}
//function adduser() {
//
//}
//
////login function
//function login() {
//}
//
////load user
//function loaduser() {
//}
//
////clear user
//function clearuser() {
//}

//ADMIN FUNCTIONS GO HERE
//function to toggle hidden on css admin tags depending on userRole
function toggleadminview() {
}


//load unposted pages and blogs
function loadunposteditems() {
}

//clear unposted pages and blogs
function clearunposteditems() {
}


//MISC SHIT GOES HERE!!!
//clear navbar
function clearnavbar() {
}

//load navbar
function loadnavbar() {
}


//search function
function search() {
}




