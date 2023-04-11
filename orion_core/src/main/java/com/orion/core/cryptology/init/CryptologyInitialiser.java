package com.orion.core.cryptology.init;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.init.tasks.LoadCryptologyConfigurationTask;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

@Order(value = 2)
public class CryptologyInitialiser extends Orion implements WebApplicationInitializer
{
    private static final transient Logger LOG = Logger.getLogger(CryptologyInitialiser.class.getName());
    public static boolean cryptologyInitialised = false;


    @Override
    public void onStartup(ServletContext servletContext)
    {

        if(!CryptologyInitialiser.cryptologyInitialised)
        {
            LOG.info("Orion Cryptology is initialising...");

            try
            {
                LoadCryptologyConfigurationTask.run();
                CryptologyInitialiser.cryptologyInitialised = true;
            }
            catch(ClassNotFoundException e)
            {
                //throw new CryptologyInitialisationException(e);
            }
            catch(NoSuchAlgorithmException e)
            {
                //throw new CryptologyInitialisationException(e);
            }
            catch(InvalidKeySpecException e)
            {
                //throw new CryptologyInitialisationException(e);
            }
            catch(IOException e)
            {
                //throw new CryptologyInitialisationException(e);
            }

        }

    }
}