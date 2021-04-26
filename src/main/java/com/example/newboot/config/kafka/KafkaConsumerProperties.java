package com.example.newboot.config.kafka;


import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("frms.workflow.kafka")
public class KafkaConsumerProperties {
    private String kafkaBrokers;
    private String compressionType = "gzip";
    private String sessionTimeout = "15000";
    private String retries = "0";
    @NestedConfigurationProperty
    private KafkaConsumerProperties.ProductionKafkaConsumerProperties production;
    @NestedConfigurationProperty
    private KafkaConsumerProperties.SimulationKafkaConsumerProperties simulation;
    @NestedConfigurationProperty
    private KafkaConsumerProperties.IndicatorKafkaConsumerProperties indicator;

    public KafkaConsumerProperties() {
    }

    public String getKafkaBrokers() {
        return this.kafkaBrokers;
    }

    public String getCompressionType() {
        return this.compressionType;
    }

    public String getSessionTimeout() {
        return this.sessionTimeout;
    }

    public String getRetries() {
        return this.retries;
    }

    public KafkaConsumerProperties.ProductionKafkaConsumerProperties getProduction() {
        return this.production;
    }

    public KafkaConsumerProperties.SimulationKafkaConsumerProperties getSimulation() {
        return this.simulation;
    }

    public KafkaConsumerProperties.IndicatorKafkaConsumerProperties getIndicator() {
        return this.indicator;
    }

    public void setKafkaBrokers(String kafkaBrokers) {
        this.kafkaBrokers = kafkaBrokers;
    }

    public void setCompressionType(String compressionType) {
        this.compressionType = compressionType;
    }

    public void setSessionTimeout(String sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public void setRetries(String retries) {
        this.retries = retries;
    }

    public void setProduction(KafkaConsumerProperties.ProductionKafkaConsumerProperties production) {
        this.production = production;
    }

    public void setSimulation(KafkaConsumerProperties.SimulationKafkaConsumerProperties simulation) {
        this.simulation = simulation;
    }

    public void setIndicator(KafkaConsumerProperties.IndicatorKafkaConsumerProperties indicator) {
        this.indicator = indicator;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof KafkaConsumerProperties)) {
            return false;
        } else {
            KafkaConsumerProperties other = (KafkaConsumerProperties)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$kafkaBrokers = this.getKafkaBrokers();
                    Object other$kafkaBrokers = other.getKafkaBrokers();
                    if (this$kafkaBrokers == null) {
                        if (other$kafkaBrokers == null) {
                            break label95;
                        }
                    } else if (this$kafkaBrokers.equals(other$kafkaBrokers)) {
                        break label95;
                    }

                    return false;
                }

                Object this$compressionType = this.getCompressionType();
                Object other$compressionType = other.getCompressionType();
                if (this$compressionType == null) {
                    if (other$compressionType != null) {
                        return false;
                    }
                } else if (!this$compressionType.equals(other$compressionType)) {
                    return false;
                }

                Object this$sessionTimeout = this.getSessionTimeout();
                Object other$sessionTimeout = other.getSessionTimeout();
                if (this$sessionTimeout == null) {
                    if (other$sessionTimeout != null) {
                        return false;
                    }
                } else if (!this$sessionTimeout.equals(other$sessionTimeout)) {
                    return false;
                }

                label74: {
                    Object this$retries = this.getRetries();
                    Object other$retries = other.getRetries();
                    if (this$retries == null) {
                        if (other$retries == null) {
                            break label74;
                        }
                    } else if (this$retries.equals(other$retries)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$production = this.getProduction();
                    Object other$production = other.getProduction();
                    if (this$production == null) {
                        if (other$production == null) {
                            break label67;
                        }
                    } else if (this$production.equals(other$production)) {
                        break label67;
                    }

                    return false;
                }

                Object this$simulation = this.getSimulation();
                Object other$simulation = other.getSimulation();
                if (this$simulation == null) {
                    if (other$simulation != null) {
                        return false;
                    }
                } else if (!this$simulation.equals(other$simulation)) {
                    return false;
                }

                Object this$indicator = this.getIndicator();
                Object other$indicator = other.getIndicator();
                if (this$indicator == null) {
                    if (other$indicator != null) {
                        return false;
                    }
                } else if (!this$indicator.equals(other$indicator)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof KafkaConsumerProperties;
    }

    @Override
    public int hashCode() {
//        int PRIME = true;
        boolean PRIME = true;
        int result = 1;
        Object $kafkaBrokers = this.getKafkaBrokers();
//        int result = result * 59 + ($kafkaBrokers == null ? 43 : $kafkaBrokers.hashCode());
        result = result * 59 + ($kafkaBrokers == null ? 43 : $kafkaBrokers.hashCode());
        Object $compressionType = this.getCompressionType();
        result = result * 59 + ($compressionType == null ? 43 : $compressionType.hashCode());
        Object $sessionTimeout = this.getSessionTimeout();
        result = result * 59 + ($sessionTimeout == null ? 43 : $sessionTimeout.hashCode());
        Object $retries = this.getRetries();
        result = result * 59 + ($retries == null ? 43 : $retries.hashCode());
        Object $production = this.getProduction();
        result = result * 59 + ($production == null ? 43 : $production.hashCode());
        Object $simulation = this.getSimulation();
        result = result * 59 + ($simulation == null ? 43 : $simulation.hashCode());
        Object $indicator = this.getIndicator();
        result = result * 59 + ($indicator == null ? 43 : $indicator.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaConsumerProperties(kafkaBrokers=" + this.getKafkaBrokers() + ", compressionType=" + this.getCompressionType() + ", sessionTimeout=" + this.getSessionTimeout() + ", retries=" + this.getRetries() + ", production=" + this.getProduction() + ", simulation=" + this.getSimulation() + ", indicator=" + this.getIndicator() + ")";
    }

    public static class IndicatorKafkaConsumerProperties {
        private Boolean enable;

        public IndicatorKafkaConsumerProperties() {
        }

        public Boolean getEnable() {
            return this.enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof KafkaConsumerProperties.IndicatorKafkaConsumerProperties)) {
                return false;
            } else {
                KafkaConsumerProperties.IndicatorKafkaConsumerProperties other = (KafkaConsumerProperties.IndicatorKafkaConsumerProperties)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$enable = this.getEnable();
                    Object other$enable = other.getEnable();
                    if (this$enable == null) {
                        if (other$enable != null) {
                            return false;
                        }
                    } else if (!this$enable.equals(other$enable)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(Object other) {
            return other instanceof KafkaConsumerProperties.IndicatorKafkaConsumerProperties;
        }

        @Override
        public int hashCode() {
//            int PRIME = true;
            boolean PRIME = true;
            int result = 1;
            Object $enable = this.getEnable();
//            int result = result * 59 + ($enable == null ? 43 : $enable.hashCode());
            result = result * 59 + ($enable == null ? 43 : $enable.hashCode());
            return result;
        }

        @Override
        public String toString() {
            return "KafkaConsumerProperties.IndicatorKafkaConsumerProperties(enable=" + this.getEnable() + ")";
        }
    }

    public static class SimulationKafkaConsumerProperties {
        private Boolean enable;
        private String groupId;
        private String workflowDataLogTopic;
        private String workflowInstanceTopic;
        private String workflowObjectTopic;
        private Boolean enableCompress;
        private boolean enableFinalStateDelayedReplica = true;
        private Duration finalStateReplicaDelay = Duration.ofSeconds(10L);

        public SimulationKafkaConsumerProperties() {
        }

        public Boolean getEnable() {
            return this.enable;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getWorkflowDataLogTopic() {
            return this.workflowDataLogTopic;
        }

        public String getWorkflowInstanceTopic() {
            return this.workflowInstanceTopic;
        }

        public String getWorkflowObjectTopic() {
            return this.workflowObjectTopic;
        }

        public Boolean getEnableCompress() {
            return this.enableCompress;
        }

        public boolean isEnableFinalStateDelayedReplica() {
            return this.enableFinalStateDelayedReplica;
        }

        public Duration getFinalStateReplicaDelay() {
            return this.finalStateReplicaDelay;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public void setWorkflowDataLogTopic(String workflowDataLogTopic) {
            this.workflowDataLogTopic = workflowDataLogTopic;
        }

        public void setWorkflowInstanceTopic(String workflowInstanceTopic) {
            this.workflowInstanceTopic = workflowInstanceTopic;
        }

        public void setWorkflowObjectTopic(String workflowObjectTopic) {
            this.workflowObjectTopic = workflowObjectTopic;
        }

        public void setEnableCompress(Boolean enableCompress) {
            this.enableCompress = enableCompress;
        }

        public void setEnableFinalStateDelayedReplica(boolean enableFinalStateDelayedReplica) {
            this.enableFinalStateDelayedReplica = enableFinalStateDelayedReplica;
        }

        public void setFinalStateReplicaDelay(Duration finalStateReplicaDelay) {
            this.finalStateReplicaDelay = finalStateReplicaDelay;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof KafkaConsumerProperties.SimulationKafkaConsumerProperties)) {
                return false;
            } else {
                KafkaConsumerProperties.SimulationKafkaConsumerProperties other = (KafkaConsumerProperties.SimulationKafkaConsumerProperties)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$enable = this.getEnable();
                    Object other$enable = other.getEnable();
                    if (this$enable == null) {
                        if (other$enable != null) {
                            return false;
                        }
                    } else if (!this$enable.equals(other$enable)) {
                        return false;
                    }

                    Object this$groupId = this.getGroupId();
                    Object other$groupId = other.getGroupId();
                    if (this$groupId == null) {
                        if (other$groupId != null) {
                            return false;
                        }
                    } else if (!this$groupId.equals(other$groupId)) {
                        return false;
                    }

                    Object this$workflowDataLogTopic = this.getWorkflowDataLogTopic();
                    Object other$workflowDataLogTopic = other.getWorkflowDataLogTopic();
                    if (this$workflowDataLogTopic == null) {
                        if (other$workflowDataLogTopic != null) {
                            return false;
                        }
                    } else if (!this$workflowDataLogTopic.equals(other$workflowDataLogTopic)) {
                        return false;
                    }

                    label78: {
                        Object this$workflowInstanceTopic = this.getWorkflowInstanceTopic();
                        Object other$workflowInstanceTopic = other.getWorkflowInstanceTopic();
                        if (this$workflowInstanceTopic == null) {
                            if (other$workflowInstanceTopic == null) {
                                break label78;
                            }
                        } else if (this$workflowInstanceTopic.equals(other$workflowInstanceTopic)) {
                            break label78;
                        }

                        return false;
                    }

                    label71: {
                        Object this$workflowObjectTopic = this.getWorkflowObjectTopic();
                        Object other$workflowObjectTopic = other.getWorkflowObjectTopic();
                        if (this$workflowObjectTopic == null) {
                            if (other$workflowObjectTopic == null) {
                                break label71;
                            }
                        } else if (this$workflowObjectTopic.equals(other$workflowObjectTopic)) {
                            break label71;
                        }

                        return false;
                    }

                    Object this$enableCompress = this.getEnableCompress();
                    Object other$enableCompress = other.getEnableCompress();
                    if (this$enableCompress == null) {
                        if (other$enableCompress != null) {
                            return false;
                        }
                    } else if (!this$enableCompress.equals(other$enableCompress)) {
                        return false;
                    }

                    if (this.isEnableFinalStateDelayedReplica() != other.isEnableFinalStateDelayedReplica()) {
                        return false;
                    } else {
                        Object this$finalStateReplicaDelay = this.getFinalStateReplicaDelay();
                        Object other$finalStateReplicaDelay = other.getFinalStateReplicaDelay();
                        if (this$finalStateReplicaDelay == null) {
                            if (other$finalStateReplicaDelay != null) {
                                return false;
                            }
                        } else if (!this$finalStateReplicaDelay.equals(other$finalStateReplicaDelay)) {
                            return false;
                        }

                        return true;
                    }
                }
            }
        }

        protected boolean canEqual(Object other) {
            return other instanceof KafkaConsumerProperties.SimulationKafkaConsumerProperties;
        }

        @Override
        public int hashCode() {
//            int PRIME = true;
            boolean PRIME = true;
            int result = 1;
            Object $enable = this.getEnable();
//            int result = result * 59 + ($enable == null ? 43 : $enable.hashCode());
            result = result * 59 + ($enable == null ? 43 : $enable.hashCode());
            Object $groupId = this.getGroupId();
            result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
            Object $workflowDataLogTopic = this.getWorkflowDataLogTopic();
            result = result * 59 + ($workflowDataLogTopic == null ? 43 : $workflowDataLogTopic.hashCode());
            Object $workflowInstanceTopic = this.getWorkflowInstanceTopic();
            result = result * 59 + ($workflowInstanceTopic == null ? 43 : $workflowInstanceTopic.hashCode());
            Object $workflowObjectTopic = this.getWorkflowObjectTopic();
            result = result * 59 + ($workflowObjectTopic == null ? 43 : $workflowObjectTopic.hashCode());
            Object $enableCompress = this.getEnableCompress();
            result = result * 59 + ($enableCompress == null ? 43 : $enableCompress.hashCode());
            result = result * 59 + (this.isEnableFinalStateDelayedReplica() ? 79 : 97);
            Object $finalStateReplicaDelay = this.getFinalStateReplicaDelay();
            result = result * 59 + ($finalStateReplicaDelay == null ? 43 : $finalStateReplicaDelay.hashCode());
            return result;
        }

        @Override
        public String toString() {
            return "KafkaConsumerProperties.SimulationKafkaConsumerProperties(enable=" + this.getEnable() + ", groupId=" + this.getGroupId() + ", workflowDataLogTopic=" + this.getWorkflowDataLogTopic() + ", workflowInstanceTopic=" + this.getWorkflowInstanceTopic() + ", workflowObjectTopic=" + this.getWorkflowObjectTopic() + ", enableCompress=" + this.getEnableCompress() + ", enableFinalStateDelayedReplica=" + this.isEnableFinalStateDelayedReplica() + ", finalStateReplicaDelay=" + this.getFinalStateReplicaDelay() + ")";
        }
    }

    public static class ProductionKafkaConsumerProperties {
        private Boolean enable;
        private String groupId;
        private Boolean enableCompress;
        private boolean enableFinalStateDelayedReplica = true;
        private Duration finalStateReplicaDelay = Duration.ofSeconds(10L);

        public ProductionKafkaConsumerProperties() {
        }

        public Boolean getEnable() {
            return this.enable;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public Boolean getEnableCompress() {
            return this.enableCompress;
        }

        public boolean isEnableFinalStateDelayedReplica() {
            return this.enableFinalStateDelayedReplica;
        }

        public Duration getFinalStateReplicaDelay() {
            return this.finalStateReplicaDelay;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public void setEnableCompress(Boolean enableCompress) {
            this.enableCompress = enableCompress;
        }

        public void setEnableFinalStateDelayedReplica(boolean enableFinalStateDelayedReplica) {
            this.enableFinalStateDelayedReplica = enableFinalStateDelayedReplica;
        }

        public void setFinalStateReplicaDelay(Duration finalStateReplicaDelay) {
            this.finalStateReplicaDelay = finalStateReplicaDelay;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof KafkaConsumerProperties.ProductionKafkaConsumerProperties)) {
                return false;
            } else {
                KafkaConsumerProperties.ProductionKafkaConsumerProperties other = (KafkaConsumerProperties.ProductionKafkaConsumerProperties)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label63: {
                        Object this$enable = this.getEnable();
                        Object other$enable = other.getEnable();
                        if (this$enable == null) {
                            if (other$enable == null) {
                                break label63;
                            }
                        } else if (this$enable.equals(other$enable)) {
                            break label63;
                        }

                        return false;
                    }

                    Object this$groupId = this.getGroupId();
                    Object other$groupId = other.getGroupId();
                    if (this$groupId == null) {
                        if (other$groupId != null) {
                            return false;
                        }
                    } else if (!this$groupId.equals(other$groupId)) {
                        return false;
                    }

                    Object this$enableCompress = this.getEnableCompress();
                    Object other$enableCompress = other.getEnableCompress();
                    if (this$enableCompress == null) {
                        if (other$enableCompress != null) {
                            return false;
                        }
                    } else if (!this$enableCompress.equals(other$enableCompress)) {
                        return false;
                    }

                    if (this.isEnableFinalStateDelayedReplica() != other.isEnableFinalStateDelayedReplica()) {
                        return false;
                    } else {
                        Object this$finalStateReplicaDelay = this.getFinalStateReplicaDelay();
                        Object other$finalStateReplicaDelay = other.getFinalStateReplicaDelay();
                        if (this$finalStateReplicaDelay == null) {
                            if (other$finalStateReplicaDelay != null) {
                                return false;
                            }
                        } else if (!this$finalStateReplicaDelay.equals(other$finalStateReplicaDelay)) {
                            return false;
                        }

                        return true;
                    }
                }
            }
        }

        protected boolean canEqual(Object other) {
            return other instanceof KafkaConsumerProperties.ProductionKafkaConsumerProperties;
        }

        @Override
        public int hashCode() {
//            int PRIME = true;
            boolean PRIME = true;
            int result = 1;
            Object $enable = this.getEnable();
//            int result = result * 59 + ($enable == null ? 43 : $enable.hashCode());
            result = result * 59 + ($enable == null ? 43 : $enable.hashCode());
            Object $groupId = this.getGroupId();
            result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
            Object $enableCompress = this.getEnableCompress();
            result = result * 59 + ($enableCompress == null ? 43 : $enableCompress.hashCode());
            result = result * 59 + (this.isEnableFinalStateDelayedReplica() ? 79 : 97);
            Object $finalStateReplicaDelay = this.getFinalStateReplicaDelay();
            result = result * 59 + ($finalStateReplicaDelay == null ? 43 : $finalStateReplicaDelay.hashCode());
            return result;
        }

        @Override
        public String toString() {
            return "KafkaConsumerProperties.ProductionKafkaConsumerProperties(enable=" + this.getEnable() + ", groupId=" + this.getGroupId() + ", enableCompress=" + this.getEnableCompress() + ", enableFinalStateDelayedReplica=" + this.isEnableFinalStateDelayedReplica() + ", finalStateReplicaDelay=" + this.getFinalStateReplicaDelay() + ")";
        }
    }
}

