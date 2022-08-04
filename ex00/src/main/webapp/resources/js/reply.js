console.log('Reply Module....')

var replyService = (function(){

  //실행할 함수 정의하는 공간
  function add(reply, callback, error){
    console.log("reply.........reply22");

    $.ajax({
      type :'post', //전송방식
      url : '/replies/new', // url주소
      data : JSON.stringify(reply),
      contentType : "application/json; charset = utf-8",
      success : function(result, status, xhr){
        if(callback){  //status : 상태정보  , xhr : 통신 객체 정보(비동기데이터 전송요청) 생략가능이나 보통 넣어준다.
          callback(result);
        }
      },
      error : function(xhr, status, err){
        if(error){
          error(err);
        }
      }
    });
  }//end of add

  function getList(param, callback, error){
    var bno = param.bno;
    var page = param.page || 1 ;   //page번호가 오면 page번호 쓰고, 아니면 1을 쓰겠다. null값오면 1 쓰겠다.
    //get JSON 요청할 때만 쓸 수 있다. ajax가 조금 복잡해서 조금 더 간다하게 쓰기 위해.
    $.getJSON("/replies/pages/" + bno + "/" + page + ".json" ,  //경로
      function(data){   //성공 시
        if(callback){
          callback(data);
        }
      }).fail(function(xhr, status, err){
        if(error) {
          error(err);
        }
      });
  }//end of getlist

  function remove(rno, callback, error){
    $.ajax({
      type : 'delete',
      url : "/replies/" + rno,
      success : function(deleteResult, status, xhr){
        if(callback) callback(deleteResult);
      },
      error : function(xhr, status, err){
        if(error) error(err);
      }
    });
  }// end of remove

  function update(reply, callback, error){
    console.log("update.........");
    
    $.ajax({
      type : 'put',
      url : '/replies/' + reply.rno,
      data : JSON.stringify(reply),
      contentType : "application/json; charset = utf-8",
      success : function(result, status, xhr){
        if(callback){
          callback(result);
        }
      },
      error : function(xhr, status, err){
        if(error){
          error(err);
        }
      }
    });
  }//end of update


  return {     //함수를 객체로 만들어서 리턴.
    add: add,
    getList : getList,
    remove : remove,
    update : update
  }; 
})();

