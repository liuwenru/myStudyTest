/*
 * Copyright Notice:
 *      Copyright  1998-2013, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.huawei.fusioninsight.solr.example;

import java.io.File;
import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient.Builder;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSample {
	private static final Logger LOG = LoggerFactory.getLogger(TestSample.class);
	
	private static CloudSolrClient getCloudSolrClient2() {

		String principal = "solr6";
		String zookeeperDefaultServerPrincipal = "zookeeper/hadoop.hadoop.com";

		String path = System.getProperty("user.dir") + File.separator + "conf" + File.separator;
		path = path.replace("\\", "\\\\");
		System.out.println(path);
		try {
			KrbLoginUtil.setJaasFile(principal, path + "user.keytab");
			KrbLoginUtil.setKrb5Config(path + "krb5.conf");
			KrbLoginUtil.setZookeeperServerPrincipal(zookeeperDefaultServerPrincipal);

		} catch (IOException e) {
			LOG.error("Failed to set security conf", e);
			throw new RuntimeException("Failed to set security conf", e);
		}

		String zkHost = "162.1.10.41:24002,162.1.10.42:24002,162.1.10.43:24002/solr";
		int zkConnectTimeout = 3000;

		Builder builder = new CloudSolrClient.Builder();
		builder.withZkHost(zkHost);
		CloudSolrClient cloudSolrClient = builder.build();

		cloudSolrClient.setZkClientTimeout(zkConnectTimeout);
		cloudSolrClient.setZkConnectTimeout(zkConnectTimeout);
		cloudSolrClient.connect();
		
		return cloudSolrClient;
	}

	public static void dotestmeds() throws  IOException, SolrServerException, InterruptedException {
		
		CloudSolrClient cloudSolrClient = getCloudSolrClient2();
		CollectionAdminRequest.Create create = new CollectionAdminRequest.Create();
        create.setConfigName("solrconf");
        create.setCollectionName("test_201");
        create.setNumShards(3);// 分片
        create.setMaxShardsPerNode(10);// 每个节点最多持有片
        create.setReplicationFactor(1);// 备份数
        create.setMethod(METHOD.POST);
        create.process(cloudSolrClient);
        
        create = new CollectionAdminRequest.Create();
        create.setConfigName("solrconf");
        create.setCollectionName("test_202");
        create.setNumShards(3);// 分片
        create.setMaxShardsPerNode(10);// 每个节点最多持有片
        create.setReplicationFactor(1);// 备份数
        create.setMethod(METHOD.POST);
        create.process(cloudSolrClient);
		SolrQuery query = new SolrQuery();
		query.setQuery("name:Luna*");
		QueryResponse response = cloudSolrClient.query("col2_test2", query);

		SolrDocumentList docs = response.getResults();
		LOG.info("Query wasted time : {}ms", response.getQTime());

		LOG.info("Total doc num : {}", docs.getNumFound());
		for (SolrDocument doc : docs) {
			LOG.info("doc detail : " + doc.getFieldValueMap());
		}
		cloudSolrClient.close();
		Thread.sleep(100*1000);
	}
}
