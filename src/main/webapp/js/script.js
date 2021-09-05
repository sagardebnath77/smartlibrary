/**
 * 
 */
const url = urlP;
let pdfDoc = null,
    pageNum = 1,
    pageIsRendering = false,
    pageNumIsPending = null;

const scale =1.5,
    //make canvas for displaying
    canvas = document.querySelector("#pdf-view"),
    ctx = canvas.getContext("2d");

    // Render the page
    function renderPage(num){

        pageIsRendering = true;
        
        pdfDoc.getPage(num).then(page => {
            const viewport = page.getViewport({ scale });
            canvas.height =viewport.height;
            canvas.width = viewport.width;
            const renderCtx = {
                canvasContext : ctx,
                viewport
            }
            page.render(renderCtx).promise.then(() => {
                pageIsRendering = false
                if(pageNumIsPending !== null ){
                
                    renderPage(pageNumIsPending);
                    pageNumIsPending = null;

                }

            });
            document.getElementById("page-num").value=num;
        });

    }
    // check for pages rendering

    const queueRenderPage =  num =>{
        if(pageIsRendering){
            pageNumIsPending = num;
        }else{
            renderPage(num);
        }
    }

    //show pre pages 
    const showPrevPage = () =>{
        if(pageNum <= 1){
            return;
        }
        pageNum--;
        queueRenderPage(pageNum);
        
    };
    //show next pages 
    const showNextPage = () =>{
        if(pageNum >= pdfDoc.numPages){
            
            return;
        }
        
        pageNum++;
        queueRenderPage(pageNum);

    }
    
    const showPage = () =>{
        
        jumpNo=parseInt(document.getElementById("jumPage").value)
        queueRenderPage(jumpNo)
    }

    // get document through pdf.js lib
    pdfjsLib.getDocument(url).promise.then(pdfDoc_p => {

        pdfDoc = pdfDoc_p;
      //  console.log(pdfDoc);
      document.getElementById("total-num").value = pdfDoc.numPages;

      renderPage(pageNum);

    });

// button events
document.getElementById("prev-btn").addEventListener('click',showPrevPage);
document.getElementById("next-btn").addEventListener("click",showNextPage);

document.getElementById("jump-btn").addEventListener("click",showPage);
