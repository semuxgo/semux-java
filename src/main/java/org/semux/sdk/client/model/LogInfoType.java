/*
 * Semux API
 * Semux is an experimental high-performance blockchain platform that powers decentralized application.
 *
 * OpenAPI spec version: 2.5.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.semux.sdk.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * LogInfoType
 */

public class LogInfoType {
  @JsonProperty("address")
  private String address = null;

  @JsonProperty("data")
  private String data = null;

  @JsonProperty("topics")
  private List<String> topics = null;

  public LogInfoType address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Contract address
   * @return address
  **/
  @ApiModelProperty(value = "Contract address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public LogInfoType data(String data) {
    this.data = data;
    return this;
  }

   /**
   * Log data encoded in hexadecimal string
   * @return data
  **/
  @ApiModelProperty(value = "Log data encoded in hexadecimal string")
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public LogInfoType topics(List<String> topics) {
    this.topics = topics;
    return this;
  }

  public LogInfoType addTopicsItem(String topicsItem) {
    if (this.topics == null) {
      this.topics = new ArrayList<String>();
    }
    this.topics.add(topicsItem);
    return this;
  }

   /**
   * Log topics encoded in hexadecimal string
   * @return topics
  **/
  @ApiModelProperty(value = "Log topics encoded in hexadecimal string")
  public List<String> getTopics() {
    return topics;
  }

  public void setTopics(List<String> topics) {
    this.topics = topics;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogInfoType logInfoType = (LogInfoType) o;
    return Objects.equals(this.address, logInfoType.address) &&
        Objects.equals(this.data, logInfoType.data) &&
        Objects.equals(this.topics, logInfoType.topics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, data, topics);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogInfoType {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    topics: ").append(toIndentedString(topics)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

