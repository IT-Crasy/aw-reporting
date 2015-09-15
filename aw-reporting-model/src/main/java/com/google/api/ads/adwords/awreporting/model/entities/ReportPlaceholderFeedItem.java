// Copyright 2011 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.awreporting.model.entities;

import com.google.api.ads.adwords.awreporting.model.csv.annotation.CsvField;
import com.google.api.ads.adwords.awreporting.model.csv.annotation.CsvReport;
import com.google.api.ads.adwords.lib.jaxb.v201506.ReportDefinitionReportType;
import com.google.common.collect.Lists;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Specific Report class for PlaceholderFeedItem
 *
 * @author markbowyer@google.com (Mark R. Bowyer)
 */

@Entity
@com.googlecode.objectify.annotation.Entity
@Table(name = "AW_ReportPlaceholderFeedItem")
@CsvReport(value = ReportDefinitionReportType.PLACEHOLDER_FEED_ITEM_REPORT)
public class ReportPlaceholderFeedItem extends ReportBase {
  
  public static final String FEED_ID = "feedId";
  public static final String FEED_ITEM_ID = "feedItemId";

  @Column(name = "CAMPAIGN_ID")
  @CsvField(value = "Campaign ID", reportField = "CampaignId")
  private Long campaignId;

  @Column(name = "CAMPAIGN_NAME", length = 255)
  @CsvField(value = "Campaign", reportField = "CampaignName")
  private String campaignName;
  
  @Column(name = "CAMPAIGN_STATUS", length = 32)
  @CsvField(value = "Campaign state", reportField = "CampaignStatus")
  private String campaignStatus;

  @Column(name = "STATUS", length = 32)
  @CsvField(value = "Item state", reportField = "Status")
  private String status;

  @Column(name = "ADGROUP_ID")
  @CsvField(value = "Ad group ID", reportField = "AdGroupId")
  private Long adGroupId;

  @Column(name = "ADGROUP_NAME", length = 255)
  @CsvField(value = "Ad group", reportField = "AdGroupName")
  private String adGroupName;
  
  @Column(name = "ADGROUP_STATUS", length = 32)
  @CsvField(value = "Ad group state", reportField = "AdGroupStatus")
  private String adGroupStatus;

  @Column(name = "AD_ID")
  @CsvField(value = "Ad ID", reportField = "AdId")
  private Long adId;

  @Column(name = "FEED_ID")
  @CsvField(value = "Feed ID", reportField = "FeedId")
  private Long feedId;

  @Column(name = "FEED_ITEM_ID")
  @CsvField(value = "Item ID", reportField = "FeedItemId")
  private Long feedItemId;

  @Column(name = "FEED_PLACEHOLDER_TYPE")
  @CsvField(value = "Feed placeholder type", reportField = "PlaceholderType")
  private int feedPlaceholderType;

  @Column(name = "IS_SELF_ACTION", length=32)
  @CsvField(value = "This extension vs. Other", reportField = "IsSelfAction")
  private String isSelfAction;
  
  @Column(name = "KEYWORD_ID")
  @CsvField(value="Keyword ID", reportField = "KeywordId")
  private Long keywordId;
  
  @Column(name = "KEYWORD_MATCH_TYPE", length=32)
  @CsvField(value = "Target keyword match type", reportField = "KeywordMatchType")
  private String keywordMatchType;
  
  @Column(name = "CRITERIA", length=255)
  @CsvField(value = "Target keyword text", reportField = "Criteria")
  private String criteria;
  
  @Column(name = "CONVERSION_TRACKER_ID")
  @CsvField(value = "Conversion Tracker Id", reportField = "ConversionTrackerId")
  private Long conversionTrackerId;
  
  @Column(name = "ATTRIBUTE_VALUES", length=2048)
  @CsvField(value = "Attribute Values", reportField = "AttributeValues")
  private String attributeValues;
  
  @Column(name = "DISAPPROVAL_SHORT_NAMES", length=2048)
  @CsvField(value = "Disapproval reasons", reportField = "DisapprovalShortNames")
  private String disapprovalShortNames;
  
  @Column(name = "URL_CUSTOM_PARAMETERS", length=2048)
  @CsvField(value = "Custom parameter", reportField = "UrlCustomParameters")
  private String urlCustomParameters;
  
  /**
   * Hibernate needs an empty constructor
   */
  public ReportPlaceholderFeedItem() {}

  public ReportPlaceholderFeedItem(Long topAccountId, Long accountId) {
    this.topAccountId = topAccountId;
    this.accountId = accountId;
  }

  @Override
  public void setId() {

    // Generating unique id after having date and accountId
    if (this.getAccountId() != null) {
      this.id = this.getAccountId().toString();
    }
    if (this.getCampaignId() != null) {
      this.id += "-" + this.getCampaignId().toString();
    }
    if (this.getAdGroupId() != null) {
      this.id += "-" + this.getAdGroupId().toString();
    }
    if (this.getAdId() != null) {
      this.id += "-" + this.getAdId().toString();
    }
    if (this.getFeedId() != null) {
      this.id += "-" + this.getFeedId().toString();
    }
    if (this.getFeedItemId() != null) {
      this.id += "-" + this.getFeedItemId().toString();
    }

    this.id += setIdDates();

    // Adding extra fields for unique ID
    if (this.getAdNetwork() != null && this.getAdNetwork().length() > 0) {
      this.id += "-" + this.getAdNetwork();
    }
    if (this.getAdNetworkPartners() != null && this.getAdNetworkPartners().length() > 0) {
      this.id += "-" + this.getAdNetworkPartners();
    }
    if (this.getDevice() != null && this.getDevice().length() > 0) {
      this.id += "-" + this.getDevice();
    }
    if (this.getClickType() != null && this.getClickType().length() > 0) {
      this.id += "-" + this.getClickType();
    }
  }

  public Long getCampaignId() {
    return campaignId;
  }

  public void setCampaignId(Long campaignId) {
    this.campaignId = campaignId;
  }

  public String getCampaignName() {
    return campaignName;
  }

  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }
  
  public String getCampaignStatus() {
    return campaignStatus;
  }

  public void setCampaignStatus(String campaignStatus) {
    this.campaignStatus = campaignStatus;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getAdGroupId() {
    return adGroupId;
  }

  public void setAdGroupId(Long adGroupId) {
    this.adGroupId = adGroupId;
  }

  public String getAdGroupName() {
    return adGroupName;
  }

  public void setAdGroupName(String adGroupName) {
    this.adGroupName = adGroupName;
  }
  
  public String getAdGroupStatus() {
    return adGroupStatus;
  }

  public void setAdGroupStatus(String adGroupStatus) {
    this.adGroupStatus = adGroupStatus;
  }

  public Long getAdId() {
    return adId;
  }

  public void setAdId(Long adId) {
    this.adId = adId;
  }

  public Long getFeedId() {
    return feedId;
  }

  public void setFeedId(Long feedId) {
    this.feedId = feedId;
  }

  public Long getFeedItemId() {
    return feedItemId;
  }

  public void setFeedItemId(Long feedItemId) {
    this.feedItemId = feedItemId;
  }

  public int getFeedPlaceholderType() {
    return feedPlaceholderType;
  }

  public void setFeedPlaceholderType(int feedPlaceholderType) {
    this.feedPlaceholderType = feedPlaceholderType;
  }

  public boolean isSelfAction() {
    return isSelfAction.equals("This extension");
  }
  
  public String getIsSelfAction() {
    return isSelfAction;
  }

  public void setIsSelfAction(String isSelfAction) {
    this.isSelfAction = isSelfAction;
  }
  
  public Long getKeywordId() {
    return keywordId;
  }
  
  public void setKeywordId(Long keywordId) {
    this.keywordId = keywordId;
  }
  
  public String getKeywordMatchType() {
    return keywordMatchType;
  }
  
  public void setKeywordMatchType(String keywordMatchType) {
    this.keywordMatchType = keywordMatchType;
  }
  
  public String getCriteria() {
    return criteria;
  }
  
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }
  
  public Long getConversionTrackerId() {
    return conversionTrackerId;
  }
  
  public void setConversionTrackerId(Long conversionTrackerId) {
    this.conversionTrackerId = conversionTrackerId;
  }
  
  public String getAttributeValues() {
    return attributeValues;
  }

  public boolean hasAttributeValue(String attributeValue) {
    if (attributeValues != null && attributeValues.length() > 0) {
      return Lists.newArrayList(attributeValues.split(";")).contains(attributeValue);
    } else {
      return false;
    }
  }

  public void setAttributeValues(String attributeValues) {
    this.attributeValues = attributeValues;
  }
  
  public String getDisapprovalShortNames() {
    return disapprovalShortNames;
  }

  public boolean hasDisapprovalShortNames(String disapprovalShortName) {
    if (disapprovalShortNames != null && disapprovalShortNames.length() > 0) {
      return Lists.newArrayList(disapprovalShortNames.split(";")).contains(disapprovalShortName);
    } else {
      return false;
    }
  }

  public void setDisapprovalShortNames(String disapprovalShortNames) {
    this.disapprovalShortNames = disapprovalShortNames;
  }
  
  public String getUrlCustomParameters() {
    return urlCustomParameters;
  }
  
  public void setUrlCustomParameters(String urlCustomParameters) {
    this.urlCustomParameters = urlCustomParameters;
  }
}
