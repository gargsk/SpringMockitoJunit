/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yahoo.garg.sharad.springmockitojunit.configuration.dev;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import yahoo.garg.sharad.springmockitojunit.util.Profiles;

/**
 *
 * @author Sharad Garg
 *         Created on Oct 3, 2017 1:03:45 PM
 */
@Configuration
@Profile(Profiles.DEV)
public class CloudContextConfiguration {
     // inserting this text to kick Jenkins build
     // using jenkins git plugin
     // // inserting this text to kick Jenkins build
     

      //      // using github webhook
}
