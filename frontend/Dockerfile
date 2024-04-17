FROM node:latest

WORKDIR /app

COPY . .

RUN npm install

RUN npm install vite

RUN npm run build

EXPOSE 5173

CMD ["npm", "run", "dev"]
# CMD ["vite", "--host 0.0.0.0"]