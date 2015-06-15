
package com.xenonstack.vanessa.core;

import java.util.ArrayList;
import com.xenonstack.vanessa.configuration.Configuration;
import java.util.List;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import com.xenonstack.vanessa.configuration.Configuration;

public class SearchAPI
{

	public Configuration conf = null;

	public SearchAPI(Configuration _conf){
		conf = _conf;
	}

	public List search(String value) throws Exception
	{
		String key="content";
		value="Main";
		List list=new ArrayList();
		String server_url=conf.get("solr.url").toString();
		HttpSolrServer solr = new HttpSolrServer(server_url);
		SolrQuery query = new SolrQuery(key+":"+value);
		QueryResponse response = solr.query(query);
		SolrDocumentList results = response.getResults();
		for (int i = 0; i < results.size(); ++i)
		{
		   list.add(results.get(i));
		}
		     return list;
	}
}
