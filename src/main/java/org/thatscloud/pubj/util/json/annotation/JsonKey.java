package org.thatscloud.pubj.util.json.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.function.Function;

@Retention( RetentionPolicy.RUNTIME )
public @interface JsonKey
{
    public Class<? extends Function<?, ?>> value();
}
