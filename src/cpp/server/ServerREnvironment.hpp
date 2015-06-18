/*
 * ServerREnvironment.hpp
 *
 * Copyright (C) 2009-12 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */

#ifndef SERVER_R_ENVIRONMENT_HPP
#define SERVER_R_ENVIRONMENT_HPP

#include <string>
#include <vector>

#include <core/r_util/REnvironment.hpp>

namespace rstudio {
namespace core {
   class Error;
   class FilePath;
}
}

namespace rstudio {
namespace server {
namespace r_environment {

bool hasFallbackVariables();
void setFallbackVariables(const core::r_util::EnvironmentVars& vars);

bool initialize(std::string* pErrMsg);

std::vector<std::pair<std::string,std::string> > variables();

bool detectREnvironment(const core::FilePath& filePath,
                        core::r_util::EnvironmentVars* pVars,
                        std::string* pErrMsg);

} // namespace r_environment
} // namespace server
} // namespace rstudio

#endif // SERVER_R_ENVIRONMENT_HPP

