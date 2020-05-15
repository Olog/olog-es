/*
 * Copyright (C) 2018 European Spallation Source ERIC.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package gov.bnl.olog;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.RestHighLevelClient;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@TestConfiguration
@EnableWebMvc
@ComponentScan(basePackages = "gov.bnl.olog")
@Import({WebSecurityConfig.class})
@Profile({ "test" })
public class ResourcesTestConfig {

    @Bean
    public LogbookRepository logbookRepository(){
        return Mockito.mock(LogbookRepository.class);
    }

    @Bean
    public PropertyRepository propertyRepository(){
        return Mockito.mock(PropertyRepository.class);
    }

    @Bean
    public LogRepository logRepository(){
        return Mockito.mock(LogRepository.class);
    }

    @Bean
    public AttachmentRepository attachmentRepository(){
        return Mockito.mock(AttachmentRepository.class);
    }

    @Bean("indexClient")
    public RestHighLevelClient client(){
        return Mockito.mock(RestHighLevelClient.class);
    }

    @Bean
    public GridFsOperations gridOperation(){
        return Mockito.mock(GridFsOperations.class);
    }

    @Bean
    public GridFsTemplate gridFsTemplate(){
        return Mockito.mock(GridFsTemplate.class);
    }

    @Bean
    public LogSearchUtil logSearchUtil(){
        return Mockito.mock(LogSearchUtil.class);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}