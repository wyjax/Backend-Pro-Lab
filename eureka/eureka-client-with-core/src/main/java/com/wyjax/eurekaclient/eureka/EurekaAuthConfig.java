package com.wyjax.eurekaclient.eureka;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.appinfo.providers.EurekaConfigBasedInstanceInfoProvider;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.discovery.shared.transport.jersey3.Jersey3TransportClientFactories;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class EurekaAuthConfig {

    private static ApplicationInfoManager applicationInfoManager;
    private static EurekaClient eurekaClient;

    @PostConstruct
    public void init() {
        DynamicPropertyFactory configInstance = DynamicPropertyFactory.getInstance();
        MyDataCenterInstanceConfig config = new MyDataCenterInstanceConfig();
        ApplicationInfoManager applicationInfoManager = initializeApplicationInfoManager(config);
        EurekaClient eurekaClient = initializeEurekaClient(applicationInfoManager,
            new DefaultEurekaClientConfig());

        EurekaService eurekaService = new EurekaService(applicationInfoManager, eurekaClient, configInstance);
        try {
            eurekaService.start();
        } finally {
            // the stop calls shutdown on eurekaClient
            eurekaService.stop();
        }
    }

    private static synchronized ApplicationInfoManager initializeApplicationInfoManager(
        EurekaInstanceConfig instanceConfig) {
        if (applicationInfoManager == null) {
            InstanceInfo instanceInfo = new EurekaConfigBasedInstanceInfoProvider(
                instanceConfig).get();
            applicationInfoManager = new ApplicationInfoManager(instanceConfig, instanceInfo);
        }

        return applicationInfoManager;
    }

    private static synchronized EurekaClient initializeEurekaClient(
        ApplicationInfoManager applicationInfoManager, EurekaClientConfig clientConfig) {
        if (eurekaClient == null) {
            eurekaClient = new DiscoveryClient(applicationInfoManager, clientConfig,
                Jersey3TransportClientFactories.getInstance());
        }

        return eurekaClient;
    }
}
