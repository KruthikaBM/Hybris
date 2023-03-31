package de.hybris.myshoestore.core.interceptor;

import de.hybris.platform.servicelayer.interceptor.Interceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

public interface ValidateInterceptor extends Interceptor {
    void onValidate(Object model, InterceptorContext ctx) throws InterceptorException;
}
