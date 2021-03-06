package com.scaleunlimited.cascading.scheme.local;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import cascading.flow.FlowProcess;
import cascading.tuple.Fields;
import cascading.tuple.Tuple;

import com.scaleunlimited.cascading.scheme.core.SolrWriter;

public class SolrCollector extends SolrWriter {

    public SolrCollector(FlowProcess<Properties> flowProcess, Fields sinkFields, File solrCoreDir, int maxSegments, String dataDirPropertyName, String dataDir) throws IOException {
        super(new LocalKeepAliveHook(flowProcess), sinkFields, dataDirPropertyName, dataDir, solrCoreDir, maxSegments);
    }
    
    public void collect(Tuple value) throws IOException {
        add(value);
    }
    

    public void cleanup() throws IOException {
        super.cleanup();
    }
    
}
