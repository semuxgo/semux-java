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
import org.semux.sdk.client.model.ApiHandlerResponse;
import org.semux.sdk.client.model.PeerType;

/**
 * GetPeersResponse
 */

public class GetPeersResponse extends ApiHandlerResponse {
  @JsonProperty("result")
  private List<PeerType> result = null;

  public GetPeersResponse result(List<PeerType> result) {
    this.result = result;
    return this;
  }

  public GetPeersResponse addResultItem(PeerType resultItem) {
    if (this.result == null) {
      this.result = new ArrayList<PeerType>();
    }
    this.result.add(resultItem);
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")
  public List<PeerType> getResult() {
    return result;
  }

  public void setResult(List<PeerType> result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPeersResponse getPeersResponse = (GetPeersResponse) o;
    return Objects.equals(this.result, getPeersResponse.result) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPeersResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

