package org.openmetadata.service.search.elasticsearch.dataInsightAggregators;

import org.apache.lucene.search.TotalHits;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.openmetadata.service.dataInsight.UnusedAssetsAggregator;

public class ElasticSearchUnusedAssetsAggregator extends UnusedAssetsAggregator<SearchHits, SearchHit, TotalHits> {
  public ElasticSearchUnusedAssetsAggregator(SearchHits hits) {
    super(hits);
  }

  @Override
  protected Object getDataFromSource(SearchHit hit) {
    return hit.getSourceAsMap().get("data");
  }

  @Override
  protected TotalHits totalHits(SearchHits hits) {
    return hits.getTotalHits();
  }

  @Override
  protected Long getTotalHitsValue(TotalHits totalHits) {
    return totalHits.value;
  }
}
