package com.learning.fred.design.principle.action.resposibilty.v1;

/**
 * @author fred
 * @date 2020/12/28 13:42
 * @description todo
 */
public abstract class Handler {
    
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    
    public final void handle() {
        boolean handled = doHandle();
        
        if (successor != null && !handled) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}
