package com.wimdeblauwe.examples.todomvchtmx.thymeleaf;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class HtmxDialect extends AbstractProcessorDialect {

    public HtmxDialect() {
        super("Htmx", "hx", 100);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        Set<IProcessor> htmxProcessors = new LinkedHashSet<>();

        htmxProcessors.add(new HtmxAttributeProcessor(dialectPrefix, "get"));
        htmxProcessors.add(new HtmxAttributeProcessor(dialectPrefix, "post"));
        htmxProcessors.add(new HtmxAttributeProcessor(dialectPrefix, "put"));
        htmxProcessors.add(new HtmxAttributeProcessor(dialectPrefix, "delete"));
        htmxProcessors.add(new HtmxAttributeProcessor(dialectPrefix, "patch"));
        htmxProcessors.add(new HtmxAttributeProcessor(dialectPrefix, "target"));

        return htmxProcessors;
    }
}
