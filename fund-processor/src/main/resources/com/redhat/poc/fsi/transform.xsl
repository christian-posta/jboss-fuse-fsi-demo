<?xml version="1.0" encoding="UTF-8"?>
 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  xmlns:ns1="http://poc.jboss.org/model/xml">

<!--  <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" > -->
<xsl:output method="xml" />

<xsl:template match="*">
 <xsl:copy>
  <xsl:apply-templates select="@*|node()"/>
 </xsl:copy>
</xsl:template>

<!--  <xsl:template match="ns1:transaction/ns1:transactionType/text()">THIS SHOULD BE A MODIFIED VALUE</xsl:template>--> 
   <xsl:template match="ns1:fundName">
      <xsl:copy-of select="."/>
      <fundType>Currency</fundType>
      <fundStatus>Active</fundStatus>
   </xsl:template>
</xsl:stylesheet> 