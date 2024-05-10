package org.example.mvc.view;

/**
 * 역할 - viewName 을 받아서 view 를 결정함
 */
public interface ViewResolver {
    View resolver(String viewName);
}
