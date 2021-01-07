package view;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

public class LocaleBean {
    private String userLocale = "en_US";
    private RichSelectOneChoice localeSelector;

    public LocaleBean() {
    }

    public void setUserLocale(String userLocale) {
        this.userLocale = userLocale;
    }

    public String getUserLocale() {
        return userLocale;
    }

    public void setLocaleSelector(RichSelectOneChoice localeSelector) {
        this.localeSelector = localeSelector;
    }

    public RichSelectOneChoice getLocaleSelector() {
        return localeSelector;
    }
}
