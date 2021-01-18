package org.example.pagefactory;

public interface SwitchIframe {

    /**
     * 切换到当前iframe
     */
    public void switchToCurrentIframe(String iframeName);


    /**
     *切换到顶层iframe
     */
    public void switchToTopIframe();
}
