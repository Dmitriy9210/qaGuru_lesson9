package web;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {

    boolean remote();

    BrowserName browserName();

    URL remoteURL();

}
