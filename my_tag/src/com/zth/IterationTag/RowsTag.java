package com.zth.IterationTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class RowsTag implements IterationTag {

    private PageContext pageContext = null;
    private int counter = 0;

    // 1. 构造方法

    //2. setPageContext
    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    // 3. setParent
    @Override
    public void setParent(Tag tag) {

    }

    // 4. setCounter
    public void setCounter(int counter) {
        this.counter = counter;
    }

    // 5. doStartTag
    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }

    // 6. doAfterBody
    @Override
    public int doAfterBody() throws JspException {
        if (--counter>0){
            return IterationTag.EVAL_BODY_AGAIN;
        }else {
            return Tag.SKIP_BODY;
        }
    }

    // 7. doEndTag
    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    // 8. realease

    @Override
    public void release() {

    }

    public int getCounter() {
        return counter;
    }

    @Override
    public Tag getParent() {
        return null;
    }


}
