FROM node:12-alpine

RUN mkdir -p /frontend
WORKDIR /usr/frontend
COPY package*.json ./
COPY package.json /frontend/package.json
COPY package-lock.json /frontend/package-lock.json
RUN npm install --production
COPY . .
CMD ["npm", "run", "serve"]
